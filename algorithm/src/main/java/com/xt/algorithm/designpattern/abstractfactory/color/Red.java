package com.xt.algorithm.designpattern.abstractfactory.color;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:43
 */
public class Red implements Color {

  @Override
  public void fill() {
    System.out.println("Inside Red::fill() method.");
  }
}
