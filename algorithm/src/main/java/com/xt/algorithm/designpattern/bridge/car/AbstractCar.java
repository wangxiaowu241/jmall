package com.xt.algorithm.designpattern.bridge.car;

import com.xt.algorithm.designpattern.bridge.engine.AbstractEngine;
import com.xt.algorithm.designpattern.bridge.sit.AbstractSit;

/**
 * 车的抽象类
 *
 * @author wangxiaoteng
 * @date 2019/5/7 14:41
 */
public abstract class AbstractCar {

  protected AbstractEngine engine;

  protected AbstractSit sit;

  public AbstractCar(AbstractEngine engine, AbstractSit sit) {
    this.engine = engine;
    this.sit = sit;
  }

  /**
   * 启动
   */
  public abstract void run();

  /**
   * 入座
   */
  public abstract void sit();
}
