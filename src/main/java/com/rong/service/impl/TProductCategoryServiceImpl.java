package com.rong.service.impl;

import com.rong.entity.TProductCategory;
import com.rong.mapper.TProductCategoryMapper;
import com.rong.service.TProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: TProductCategoryServiceImpl
 * @projectName Supermarket
 * @description: TODO
 * @author 荣兵强
 * @date 2022/2/2115:51
 */
@Service
public class TProductCategoryServiceImpl implements TProductCategoryService {

    @Autowired
    private TProductCategoryMapper tProductCategoryMapper;
    @Override
    public List<TProductCategory> findAllParent() {
        return tProductCategoryMapper.findAllParent();
    }
}
