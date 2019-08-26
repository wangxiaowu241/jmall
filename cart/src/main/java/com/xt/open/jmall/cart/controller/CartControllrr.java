
package com.xt.open.jmall.cart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @version $Id: CartControllrr.java,v 1.0 2018/12/7 10:28 AM wangxiaoteng
 * @date 2018/12/7 下午10:28 AM
 */
@RestController
@RequestMapping("/cart")
@Api(value = "购物车", tags = {"购物车"})
public class CartControllrr {


    @ApiOperation("添加商品到购物车")
    @ApiImplicitParam(name = "productId",value = "productId",required = true,paramType ="path",dataType = "String")
    @PostMapping("/{productId}")
    public ResponseEntity addCart(@PathVariable("productId") Long productId) throws InterruptedException {
        Thread.sleep(5000);

        System.out.println(productId);
        return ResponseEntity.ok(productId);
    }
}
