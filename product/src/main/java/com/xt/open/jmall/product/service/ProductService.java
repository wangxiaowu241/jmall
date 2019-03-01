/**
 * $Id: ProductService.java,v 1.0 2019/1/22 11:23 AM wangxiaoteng
 *
 * @Copyright (c) 2019/1/22, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.product.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.xt.open.jmall.product.remote.feignclients.CartFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.Future;

/**
 * 类注释，描述
 *
 * @author wangxiaoteng
 * @version $Id: ProductService.java,v 1.0 2019/1/22 11:23 AM wangxiaoteng
 * @date 2019/1/22 下午11:23 AM
 */
@Service
@Slf4j
public class ProductService {

    @Autowired
    private CartFeignClient cartFeignClient;

    @HystrixCommand(fallbackMethod = "getDefaultAsyncAddCart")
    public Future<ResponseEntity<Long>> asyncAddCart(@PathVariable("productId") Long productId) throws InterruptedException {
        System.out.println("异步command：run。。。");
        Thread.sleep(5000);
        return new AsyncResult<ResponseEntity<Long>>() {
            @Override
            public ResponseEntity<Long> invoke() {
                return ResponseEntity.ok(cartFeignClient.addCart(productId));
            }
        };
    }

    private ResponseEntity<Long> getDefaultAsyncAddCart(Long productId, Throwable throwable) {
        System.out.println("异步command，同步fallback：run。。。");
        log.warn("", throwable);
        return ResponseEntity.ok(0L);
    }

    @HystrixCommand(fallbackMethod = "getDefaultAsyncAddCart2")
    public Future<ResponseEntity<Long>> asyncAddCart2(@PathVariable("productId") Long productId) throws InterruptedException {
        System.out.println("异步command：run。。。");
        Thread.sleep(5000);
        return new AsyncResult<ResponseEntity<Long>>() {
            @Override
            public ResponseEntity<Long> invoke() {
                return ResponseEntity.ok(cartFeignClient.addCart(productId));
            }
        };
    }

    @HystrixCommand
    private Future<ResponseEntity<Long>> getDefaultAsyncAddCart2(Long productId, Throwable throwable) {
        System.out.println("异步command，同步fallback：run。。。");
        log.warn("", throwable);
        return new AsyncResult<ResponseEntity<Long>>() {
            @Override
            public ResponseEntity<Long> invoke() {
                return ResponseEntity.ok(0L);
            }
        };
    }
}
