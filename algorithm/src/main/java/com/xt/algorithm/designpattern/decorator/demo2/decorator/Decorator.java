package com.xt.algorithm.designpattern.decorator.demo2.decorator;

import com.xt.algorithm.designpattern.decorator.demo2.drink.Drink;
import java.math.BigDecimal;

/**
 * 装饰类基类
 *
 * @author wangxiaoteng
 * @date 2019/5/9 12:25
 */
public abstract class Decorator extends Drink {

  private Drink drink;

  public Decorator(Drink drink) {
    this.drink = drink;
  }

  @Override
  public BigDecimal cost() {
    return super.getPrice().add(drink.cost());
  }
}
