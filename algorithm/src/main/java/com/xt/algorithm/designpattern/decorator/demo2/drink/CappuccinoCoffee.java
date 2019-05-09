package com.xt.algorithm.designpattern.decorator.demo2.drink;

import java.math.BigDecimal;

/**
 * 卡布奇诺咖啡
 *
 * @author wangxiaoteng
 * @date 2019/5/9 12:23
 */
public class CappuccinoCoffee extends Coffee {

  public CappuccinoCoffee() {
    super.setDescription("卡布奇诺咖啡");
    super.setPrice(BigDecimal.ZERO);
  }
}
