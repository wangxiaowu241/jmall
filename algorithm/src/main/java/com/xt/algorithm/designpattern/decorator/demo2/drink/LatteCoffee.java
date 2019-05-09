package com.xt.algorithm.designpattern.decorator.demo2.drink;

import java.math.BigDecimal;

/**
 * 拿铁咖啡
 *
 * @author wangxiaoteng
 * @date 2019/5/9 12:23
 */
public class LatteCoffee extends Coffee {

  public LatteCoffee() {
    super.setDescription("拿铁咖啡");
    super.setPrice(BigDecimal.ZERO);
  }
}
