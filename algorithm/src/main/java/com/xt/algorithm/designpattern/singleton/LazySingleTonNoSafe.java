package com.xt.algorithm.designpattern.singleton;

/**
 * 懒汉式单例-非线程安全
 *
 * <p/>
 * 是否lazy初始化：是
 * <p/>
 * 是否多线程安全：否
 * <p/>
 * 实现难度：易
 * <p/>
 *
 * @author wangxiaoteng
 * @date 2019/4/29 18:57
 */
public class LazySingleTonNoSafe {

  private static LazySingleTonNoSafe instance;

  private LazySingleTonNoSafe() {
  }

  private static LazySingleTonNoSafe getInstance() {
    if (null == instance) {
      instance = new LazySingleTonNoSafe();
    }
    return instance;
  }
}
