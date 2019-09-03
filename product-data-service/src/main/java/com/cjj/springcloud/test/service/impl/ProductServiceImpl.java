package com.cjj.springcloud.test.service.impl;

import com.cjj.springcloud.test.entity.Product;
import com.cjj.springcloud.test.service.IProductService;
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

    @Override
    public List<Product> listProducts() {
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a from port:"+port, 50));
        ps.add(new Product(2,"product b from port:"+port, 150));
        ps.add(new Product(3,"product c from port:"+port, 250));
        return ps;
    }
}
