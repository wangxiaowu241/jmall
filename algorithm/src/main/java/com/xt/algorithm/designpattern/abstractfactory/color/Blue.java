package com.xt.algorithm.designpattern.abstractfactory.color;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:43
 */
public class Blue implements Color {

  @Override
  public void fill() {
    System.out.println("Inside Blue::fill() method.");
  }
}
