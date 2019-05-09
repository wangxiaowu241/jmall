package com.xt.algorithm.designpattern.decorator.demo2.drink;

import java.math.BigDecimal;

/**
 * 饮品
 *
 * @author wangxiaoteng
 * @date 2019/5/9 11:50
 */
public abstract class Drink {

  private String description = "";

  private BigDecimal price = BigDecimal.ZERO;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description += description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public abstract BigDecimal cost();
}
