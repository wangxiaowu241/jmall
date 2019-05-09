package com.xt.algorithm.designpattern.decorator.demo2.decorator;

import com.xt.algorithm.designpattern.decorator.demo2.drink.Drink;
import java.math.BigDecimal;

/**
 * 调料-糖
 *
 * @author wangxiaoteng
 * @date 2019/5/9 13:33
 */
public class Sugar extends Decorator {

  public Sugar(Drink drink) {
    super(drink);
    setPrice(BigDecimal.ONE);
    setDescription("糖");
  }
}
