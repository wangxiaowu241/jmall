package com.xt.algorithm.designpattern.singleton;

/**
 * 饿汉式单例。缺点：类加载时就初始化（可能由于其他的静态变量导致的初始化），可能造成垃圾对象 优点：线程安全的实现单例，且执行效率较高
 * <p/>
 * 是否lazy初始化：否
 * <p/>
 * 是否多线程安全：是
 * <p/>
 * 实现难度：易
 * <p/>
 *
 * @author wangxiaoteng
 * @date 2019/4/29 19:07
 */
public class HungrySingleTon {

  private static final HungrySingleTon instance = new HungrySingleTon();

  private HungrySingleTon() {
  }

  public HungrySingleTon getInstance() {
    return instance;
  }
}
