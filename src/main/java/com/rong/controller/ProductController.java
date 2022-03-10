package com.rong.controller;

import com.rong.entity.Product;
import com.rong.entity.TProductCategory;
import com.rong.service.IProductService;
import com.rong.service.TProductCategoryService;
import com.rong.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @Autowired
    private TProductCategoryService tProductCategoryService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK, data);
    }

    @RequestMapping("findAllParent")
    public JsonResult<List<TProductCategory>> getFindAllParent() {
        List<TProductCategory> data = tProductCategoryService.findAllParent();
        return new JsonResult<List<TProductCategory>>(OK, data);
    }

    @RequestMapping("findAllByParId")
    public JsonResult<List<Product>> getFindAllByParId(Integer categoryId,Integer page) {
        List<Product> data = productService.findAllByParId(categoryId,page);
        return new JsonResult<List<Product>>(OK, data);
    }

    @RequestMapping("findAllByFuzz")
    public JsonResult<List<Product>> getfindAllByFuzz(String fuzz,Integer page) {
        List<Product> data = productService.findAllByFuzz(fuzz,page);
        return new JsonResult<List<Product>>(OK, data);
    }

    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JsonResult<Product>(OK, data);
    }

    @GetMapping("{id}/changeProduct")
    public JsonResult<Integer> changeProduct(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Integer data = productService.changeProduct(id);
        // 返回成功和数据
        return new JsonResult<Integer>(OK, data);
    }


}
