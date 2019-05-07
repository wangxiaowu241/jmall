package com.xt.algorithm.designpattern.bridge.engine;

/**
 * 多缸引擎
 *
 * @author wangxiaoteng
 * @date 2019/5/7 14:52
 */
public class MultiJarEngine extends AbstractEngine {

  @Override
  public void start() {
    System.out.println("多缸引擎启动了。。。");
  }
}
