package com.rong.service;


import com.rong.entity.Product;

import java.util.List;

/** 处理商品数据的业务层接口 */
public interface IProductService {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);
    /**
     * @Author 荣兵强
     * @Description //TODO 查询分类
     * @Date
     * @Param
     * @return
     **/
    List<Product> findAllByParId(Integer categoryId,Integer page);

    List<Product> findAllByFuzz(String fuzz,Integer page);
    /**
     * @Author 荣兵强
     * @Description //TODO
     * @Date
     * @Param
     * @return
     **/
    Integer changeProduct(Integer id );
}
