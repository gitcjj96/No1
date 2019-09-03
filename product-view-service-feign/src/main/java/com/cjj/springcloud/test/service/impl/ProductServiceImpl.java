package com.cjj.springcloud.test.service.impl;

import com.cjj.springcloud.test.entity.Product;
import com.cjj.springcloud.test.feign.ProductClientFeign;
import com.cjj.springcloud.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cjj
 * @Date: 2019/9/2 0002 下午 5:37
 * @Description：
 */
@Service
public class ProductServiceImpl implements IProductService{

    @Value("${server.port}")
    String port;
    @Autowired
    ProductClientFeign productClientFeign;

    @Override
    public List<Product> listProducts() {
        List<Product> list = productClientFeign.listProducts();
        return list;
    }
}
