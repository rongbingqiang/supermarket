package com.rong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rong.entity.Address;
import com.rong.entity.Order;
import com.rong.entity.OrderInfo;
import com.rong.entity.OrderItem;
import com.rong.mapper.OrderInfoMapper;
import com.rong.mapper.OrderMapper;
import com.rong.service.IAddressService;
import com.rong.service.ICartService;
import com.rong.service.IOrderService;
import com.rong.service.ex.InsertException;
import com.rong.vo.CartVO;
import com.rong.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/** 处理订单和订单数据的业务层实现类 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order>  implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Transactional
    @Override
    public Order create(Integer aid, Integer[] cids, Integer uid, String username) {
        // 创建当前时间对象
        Date now = new Date();

        // 根据cids查询所勾选的购物车列表中的数据
        List<CartVO> carts = cartService.getVOByCids(uid, cids);

        // 计算这些商品的总价
        long totalPrice = 0;
        for (CartVO cart : carts) {
            totalPrice += cart.getRealPrice() * cart.getNum();
        }

        // 创建订单数据对象
        Order order = new Order();
        // 补全数据：uid
        order.setUid(uid);
        // 查询收货地址数据
        Address address = addressService.getByAid(aid, uid);
        // 补全数据：收货地址相关的6项
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        // 补全数据：totalPrice
        order.setTotalPrice(totalPrice);
        // 补全数据：status
        order.setStatus(0);
        // 补全数据：下单时间
        order.setOrderTime(now);
        // 补全数据：日志
        order.setCreatedUser(username);
        order.setCreatedTime(now);
        order.setModifiedUser(username);
        order.setModifiedTime(now);
        // 插入订单数据
        Integer rows1 = orderMapper.insertOrder(order);
        if (rows1 != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        // 遍历carts，循环插入订单商品数据
        for (CartVO cart : carts) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：pid, title, image, price, num
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getRealPrice());
            item.setNum(cart.getNum());
            // 补全数据：4项日志
            item.setCreatedUser(username);
            item.setCreatedTime(now);
            item.setModifiedUser(username);
            item.setModifiedTime(now);
            // 插入订单商品数据
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
            //清楚购物车数据
            cartService.deleteByUidAndCid(cart.getUid(),cart.getPid());
        }



        // 返回
        return order;
    }



    @Override
    public List<OrderVO> findOrder(Integer uid) {
        List<OrderVO> orderVOList =  orderMapper.findOrder(uid);
        orderVOList.stream().forEach(o ->{
            o.setRealPrice(o.getPrice()*o.getNum());
        });
        return orderVOList;
    }

    @Override
    public Order deleteByUidAndCid(Integer uid, Integer pids) {
        cartService.deleteByUidAndCid(uid,pids);
        return null;
    }

    @Override
    public boolean save(Order entity) {
        return super.save(entity);
    }
}
