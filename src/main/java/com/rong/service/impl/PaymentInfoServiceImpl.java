package com.rong.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rong.entity.PaymentInfo;
import com.rong.mapper.PaymentInfoMapper;
import com.rong.service.PaymentInfoService;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

}
