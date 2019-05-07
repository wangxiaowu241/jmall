package com.xt.algorithm.designpattern.bridge.engine;

/**
 * 单缸引擎
 *
 * @author wangxiaoteng
 * @date 2019/5/7 14:51
 */
public class SingleJarEngine extends AbstractEngine {

  @Override
  public void start() {
    System.out.println("单缸引擎启动了。。。");
  }
}
