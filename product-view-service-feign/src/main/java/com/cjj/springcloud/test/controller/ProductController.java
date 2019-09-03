package com.cjj.springcloud.test.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.cjj.springcloud.test.entity.Product;
import com.cjj.springcloud.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: cjj
 * @Date: 2019/9/2 0002 下午 5:40
 * @Description：
 */
@RestController
public class ProductController {
    @Autowired IProductService productService;

    @GetMapping("/products")
    public ModelAndView products(
            ModelAndView mav
    ) {
        List<Product> ps = productService.listProducts();
        mav.addObject("ps", ps);
        mav.setViewName("products");
        return mav;
    }

    @GetMapping("/getList")
    public String getList(
    ) {
        List<Product> ps = productService.listProducts();

        return JSONUtil.formatJsonStr(JSONObject.toJSONString(ps));
    }
}
