package com.xt.algorithm.designpattern.bridge.car;

import com.xt.algorithm.designpattern.bridge.engine.AbstractEngine;
import com.xt.algorithm.designpattern.bridge.sit.AbstractSit;

/**
 * 宝马车
 *
 * @author wangxiaoteng
 * @date 2019/5/7 14:45
 */
public class BMWCar extends AbstractCar {

  public BMWCar(AbstractEngine engine, AbstractSit sit) {
    super(engine, sit);
  }

  @Override
  public void run() {
    System.out.println("宝马车开始启动了。。。");

    sit();
    engine.start();
  }

  @Override
  public void sit() {
    System.out.println("落座宝马车了。。。");
    sit.sit();
  }
}
