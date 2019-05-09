package com.xt.algorithm.designpattern.decorator.demo2.drink;

import java.math.BigDecimal;

/**
 * 咖啡基类
 *
 * @author wangxiaoteng
 * @date 2019/5/9 12:20
 */
public class Coffee extends Drink {

  @Override
  public BigDecimal cost() {

    //直接返回价格
    return super.getPrice();
  }
}
