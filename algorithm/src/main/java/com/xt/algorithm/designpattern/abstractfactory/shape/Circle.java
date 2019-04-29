package com.xt.algorithm.designpattern.abstractfactory.shape;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:26
 */
public class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Circle method running...");
  }
}
