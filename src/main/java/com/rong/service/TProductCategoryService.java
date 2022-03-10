package com.rong.service;

import com.rong.entity.TProductCategory;

import java.util.List;

/**
 * @author 荣兵强
 * @title: TProductCategoryService
 * @projectName Supermarket
 * @description: TODO
 * @date 2022/2/2115:51
 */
public interface TProductCategoryService {

    List<TProductCategory> findAllParent();
}
