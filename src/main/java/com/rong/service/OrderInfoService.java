package com.rong.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rong.entity.OrderInfo;
import com.rong.enums.OrderStatus;

import java.util.List;


public interface OrderInfoService extends IService<OrderInfo> {

    OrderInfo createOrderByProductId(Long productId);

    void saveCodeUrl(String orderNo, String codeUrl);

//    List<OrderInfo> listOrderByCreateTimeDesc();
//
//    void updateStatusByOrderNo(String orderNo, OrderStatus orderStatus);
//
//    String getOrderStatus(String orderNo);
//
//    List<OrderInfo> getNoPayOrderByDuration(int minutes);
//
//    OrderInfo getOrderByOrderNo(String orderNo);

}
