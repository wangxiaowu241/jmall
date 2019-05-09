package com.xt.algorithm.designpattern.decorator.demo1;

/**
 * @author wangxiaoteng
 * @date 2019/5/8 19:12
 */
public class ConcreteSubject implements Subject {

  @Override
  public void show() {
    System.out.println("具体执行者运行。。。");
  }
}
