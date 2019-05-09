package com.xt.algorithm.designpattern.decorator.demo1;

/**
 * @author wangxiaoteng
 * @date 2019/5/8 19:13
 */
public class SubjectDecoratorA extends AbstractDecorator {

  private String addState = "增强属性A";

  public SubjectDecoratorA(Subject subject) {
    super(subject);
  }

  @Override
  public void show() {
    super.show();
    System.out.println("具体装饰类A的增强属性为" + addState);
  }

}
