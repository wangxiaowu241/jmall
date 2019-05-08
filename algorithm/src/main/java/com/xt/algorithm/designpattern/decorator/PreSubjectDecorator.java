package com.xt.algorithm.designpattern.decorator;

/**
 * @author wangxiaoteng
 * @date 2019/5/8 19:13
 */
public class PreSubjectDecorator implements Subject {

  private Subject subject;

  public PreSubjectDecorator(Subject subject) {
    this.subject = subject;
  }

  @Override
  public void show() {
    subject.show();
  }

  private void preShow() {
    System.out.println("前置装饰。。。");
  }
}
