/**
 * $Id: ProductController.java,v 1.0 2018/12/10 11:40 AM wangxiaoteng
 *
 * @Copyright (c) 2018/12/10, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xt.open.jmall.product.remote.feignclients.CartFeignClient;
import com.xt.open.jmall.product.remote.feignclients.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 类注释，描述
 *
 * @author wangxiaoteng
 * @version $Id: ProductController.java,v 1.0 2018/12/10 11:40 AM wangxiaoteng
 * @date 2018/12/10 下午11:40 AM
 */
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private CartFeignClient cartFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    //@HystrixCommand(fallbackMethod = "getDefaultValue")
    @PostMapping("/toCart/{productId}")
    public ResponseEntity addCart(@PathVariable("productId") Long productId) throws InterruptedException {
        //Thread.sleep(new Random().nextInt(5000));
        Long aLong = cartFeignClient.addCart(productId);
        Long addCart = orderFeignClient.addCart(productId);
        System.out.println(addCart);
        System.out.println(aLong);
        return ResponseEntity.ok(productId);
    }

    public ResponseEntity getDefaultValue(Long productId){
        return ResponseEntity.ok(0);
    }
}
