package com.xt.algorithm.designpattern.decorator.demo2.drink;

import java.math.BigDecimal;

/**
 * 摩卡咖啡
 *
 * @author wangxiaoteng
 * @date 2019/5/9 12:23
 */
public class MochaCoffee extends Coffee {

  public MochaCoffee() {
    super.setDescription("摩卡咖啡");
    super.setPrice(BigDecimal.ZERO);
  }
}
