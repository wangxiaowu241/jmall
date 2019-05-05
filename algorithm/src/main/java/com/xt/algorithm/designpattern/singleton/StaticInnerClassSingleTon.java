package com.xt.algorithm.designpattern.singleton;

/**
 * 静态内部类实现单例
 *
 * @author wangxiaoteng
 * @date 2019/4/29 19:25
 */
public class StaticInnerClassSingleTon {

  private StaticInnerClassSingleTon() {

  }

  private StaticInnerClassSingleTon getInstance() {
    return StaticInnerClassSingleTonHolder.instance;
  }

  private static class StaticInnerClassSingleTonHolder {

    private static final StaticInnerClassSingleTon instance = new StaticInnerClassSingleTon();
  }

}
