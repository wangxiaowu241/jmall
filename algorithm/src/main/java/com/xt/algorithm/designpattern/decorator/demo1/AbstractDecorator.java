package com.xt.algorithm.designpattern.decorator.demo1;

/**
 * @author wangxiaoteng
 * @date 2019/5/9 9:40
 */
public abstract class AbstractDecorator implements Subject {

  protected Subject subject;

  public AbstractDecorator(Subject subject) {
    this.subject = subject;
  }

  @Override
  public void show() {
    subject.show();
  }
}
