package com.rong.mapper;


import com.rong.entity.TProductCategory;
import java.util.List;

public interface TProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TProductCategory tProductCategory);

    int insertSelective(TProductCategory tProductCategory);

    int updateByPrimaryKeySelective(TProductCategory tProductCategory);

    int updateByPrimaryKey(TProductCategory tProductCategory);

    TProductCategory selectById(Integer id);

    List<TProductCategory> findAllParent();
}