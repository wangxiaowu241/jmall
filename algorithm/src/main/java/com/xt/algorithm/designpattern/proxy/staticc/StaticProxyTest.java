package com.xt.algorithm.designpattern.proxy.staticc;

/**
 * 静态代理
 *
 * @author wangxiaoteng
 * @date 2019/5/8 20:56
 */
public class StaticProxyTest {

  public static void main(String[] args) {

    new UserServiceProxy(new UserServiceImpl()).save();
  }
}
