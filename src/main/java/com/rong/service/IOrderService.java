package com.rong.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rong.entity.Order;
import com.rong.entity.OrderInfo;
import com.rong.mapper.OrderMapper;
import com.rong.vo.OrderVO;

import java.util.List;

/** 处理订单和订单数据的业务层接口 */
public interface IOrderService extends IService<Order> {
    /**
     * 创建订单
     * @param aid 收货地址的id
     * @param cids 即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 成功创建的订单数据
     */
    Order create(Integer aid, Integer[] cids, Integer uid, String username);

    /**
     * @Author 荣兵强
     * @Description //TODO 获取所有的订单
     * @Date
     * @Param
     * @return
     **/
    List<OrderVO> findOrder(Integer uid);

    Order deleteByUidAndCid(Integer uid, Integer pids);
}
