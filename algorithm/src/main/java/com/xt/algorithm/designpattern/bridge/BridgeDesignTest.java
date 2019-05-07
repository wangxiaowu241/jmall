package com.xt.algorithm.designpattern.bridge;

import com.xt.algorithm.designpattern.bridge.car.BMWCar;
import com.xt.algorithm.designpattern.bridge.engine.MultiJarEngine;
import com.xt.algorithm.designpattern.bridge.engine.SingleJarEngine;
import com.xt.algorithm.designpattern.bridge.sit.FiveSit;
import com.xt.algorithm.designpattern.bridge.sit.SevenSit;

/**
 * Java设计模式-桥接模式 test
 *
 * 桥接模式：通过剥离抽象类与具体实现剥离出来，使它们都可以自由的变化。之后再通过聚合，将它们关联起来。
 *
 * 例如：一辆汽车，BMW,BENZ,LAND ROVER等，它们的发动机有单缸发动机、多缸发动机等，它们有SUV，轿车、跑车等。 从这两个角度来说，就可以有多个排列组合，如果每种组合都创建一个具体类的话，如果有N个维度，每种维度有M个变化，就有MN个具体类，
 * 类太多了，耦合度较高，而且有很多重复的功能。
 *
 * 使用桥接模式就可以很好的解决这个问题。
 *
 * 使用依赖，而不是继承来解决变化的问题
 *
 * @author wangxiaoteng
 * @date 2019/5/7 14:33
 */
public class BridgeDesignTest {

  public static void main(String[] args) {

    //五座，单缸 宝马车
    BMWCar fiveSitAndSingleJarEngineCar = new BMWCar(new SingleJarEngine(), new FiveSit());
    fiveSitAndSingleJarEngineCar.run();
    //五座，多缸 宝马车
    BMWCar fiveSitAndMultiJarEngineCar = new BMWCar(new MultiJarEngine(), new FiveSit());
    fiveSitAndMultiJarEngineCar.run();
    //七座，单缸 宝马车
    BMWCar sevenSitAndSingleJarEngineCar = new BMWCar(new SingleJarEngine(), new SevenSit());
    sevenSitAndSingleJarEngineCar.run();
    //七座，多缸 宝马车
    BMWCar sevenSitAndMultiJarEngineCar = new BMWCar(new MultiJarEngine(), new SevenSit());
    sevenSitAndMultiJarEngineCar.run();

  }
}
