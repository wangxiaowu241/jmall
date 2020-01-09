/**
 * $Id: ProductController.java,v 1.0 2018/12/10 11:40 AM
 *
 * @Copyright (c) 2018/12/10,
 */
package com.xt.open.jmall.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xt.open.jmall.product.remote.feignclients.CartFeignClient;
import com.xt.open.jmall.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * 类注释，描述
 *
 * @version $Id: ProductController.java,v 1.0 2018/12/10 11:40 AM
 * @date 2018/12/10 下午11:40 AM
 */
@RequestMapping("/product")
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private CartFeignClient cartFeignClient;

    @Autowired
    private ProductService productService;

    @HystrixCommand(fallbackMethod = "getDefaultValue")
    @PostMapping("/toCart/{productId}")
    public ResponseEntity addCart(@PathVariable("productId") Long productId){
        Long aLong = cartFeignClient.addCart(productId);
        System.out.println(aLong);

        return ResponseEntity.ok(productId);
    }

    private ResponseEntity getDefaultValue(Long productId) {
        return ResponseEntity.ok(0);
    }

    @PostMapping("/async/toCart/{productId}")
    public ResponseEntity<Long> asyncAddCart(@PathVariable("productId") Long productId) throws ExecutionException, InterruptedException {
        return productService.asyncAddCart(productId).get();
    }

    @PostMapping("/async2/toCart/{productId}")
    public ResponseEntity<Long> asyncAddCart2(@PathVariable("productId") Long productId) throws ExecutionException, InterruptedException {
        return productService.asyncAddCart2(productId).get();
    }

}
