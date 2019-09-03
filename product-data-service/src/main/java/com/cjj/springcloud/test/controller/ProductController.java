package com.cjj.springcloud.test.controller;

import com.cjj.springcloud.test.entity.Product;
import com.cjj.springcloud.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: cjj
 * @Date: 2019/9/2 0002 下午 5:40
 * @Description：
 */
@RestController
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("getList")
    public List<Product> getList(){

        return productService.listProducts();
    }
}
