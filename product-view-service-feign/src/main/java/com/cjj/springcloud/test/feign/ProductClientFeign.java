package com.cjj.springcloud.test.feign;

import com.cjj.springcloud.test.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: cjj
 * @Date: 2019/9/3 0003 上午 10:36
 * @Description：
 */
@Repository
@FeignClient(value = "PRODUCT-DATA-SERVICE")
public interface ProductClientFeign {

    @GetMapping("/getList")
    public List<Product> listProducts();
}
