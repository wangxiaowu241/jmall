package com.xt.algorithm.designpattern.decorator.demo1;

/**
 * @author wangxiaoteng
 * @date 2019/5/8 19:13
 */
public class SubjectDecoratorB extends AbstractDecorator {

  public SubjectDecoratorB(Subject subject) {
    super(subject);
  }

  @Override
  public void show() {
    super.show();
    addBehavior();
  }

  private void addBehavior() {
    System.out.println("具体装饰类B的增强方法运行。。");
  }

}
