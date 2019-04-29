package com.xt.algorithm.designpattern.abstractfactory.shape;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:24
 */
public class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Rectangle method running...");
  }
}
