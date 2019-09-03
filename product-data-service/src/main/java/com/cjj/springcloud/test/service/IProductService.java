package com.cjj.springcloud.test.service;

import com.cjj.springcloud.test.entity.Product;

import java.util.List;

/**
 * @Author: cjj
 * @Date: 2019/9/2 0002 下午 5:36
 * @Description：
 */
public interface IProductService {
    public List<Product> listProducts();
}
