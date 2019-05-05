package com.xt.algorithm.designpattern.singleton;

/**
 * 双重检查锁单例 优点：线程安全，多线程情况下效率较高  缺点：实现较复杂
 * <p/>
 * 是否lazy初始化：是
 * <p/>
 * 是否多线程安全：是
 * <p/>
 * 实现难度：较为复杂
 * <p/>
 *
 * @author wangxiaoteng
 * @date 2019/4/29 19:20
 */
public class DoubleCheckedLockSingleTon {

  private static volatile DoubleCheckedLockSingleTon instance;

  private DoubleCheckedLockSingleTon() {
  }

  public static DoubleCheckedLockSingleTon getInstance() {

    if (null == instance) {
      synchronized (DoubleCheckedLockSingleTon.class) {
        if (null == instance) {
          instance = new DoubleCheckedLockSingleTon();
        }
      }
    }
    return instance;
  }
}
