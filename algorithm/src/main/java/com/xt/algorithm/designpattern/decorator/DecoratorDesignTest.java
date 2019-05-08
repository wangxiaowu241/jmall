package com.xt.algorithm.designpattern.decorator;

/**
 * 装饰模式：动态地给类增加额外的功能
 *
 * 代理模式：为其他对象提供访问此对象的代理对象，从而控制访问权限
 *
 * 区别： 1.代理模式是为了 控制访问权限，装饰模式是为了动态增加功能
 * 2.代理类在编译时就已经确定，装饰类在调用时由客户端动态指定
 * 3.代理类是提供方创建，使用方甚至不知道被代理对象的存在，而装饰类是客户端创建并传递过来的
 *
 * @author wangxiaoteng
 * @date 2019/5/8 19:17
 */
public class DecoratorDesignTest {

  public static void main(String[] args) {

    ConcreteSubject concreteSubject = new ConcreteSubject();
    new PreSubjectDecorator(concreteSubject).show();
    new PostSubjectDecorator(concreteSubject).show();
  }
}
