package com.rong.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rong.entity.RefundInfo;
import com.rong.mapper.RefundInfoMapper;
import com.rong.service.RefundInfoService;
import org.springframework.stereotype.Service;

@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo> implements RefundInfoService {

}
