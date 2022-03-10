package com.rong.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rong.entity.Order;
import com.rong.entity.OrderItem;
import com.rong.vo.CartVO;
import com.rong.vo.OrderVO;

import java.util.List;

/** 处理订单及订单商品数据的持久层接口 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    List<OrderVO> findOrder(Integer uid);
}
