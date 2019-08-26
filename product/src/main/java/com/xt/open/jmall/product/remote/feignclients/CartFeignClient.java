/**
 * $Id: CartFeignClient.java,v 1.0 2018/12/10 11:39 AM wangxiaoteng
 *
 * @Copyright (c) 2018/12/10, Lianjia Group All Rights Reserved.
 */
package com.xt.open.jmall.product.remote.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 类注释，描述
 *
 * @version $Id: CartFeignClient.java,v 1.0 2018/12/10 11:39 AM wangxiaoteng
 * @date 2018/12/10 下午11:39 AM
 */
@FeignClient(value = "CART")
public interface CartFeignClient {

    @PostMapping("/cart/{productId}")
    Long addCart(@PathVariable("productId")Long productId);
}
