package com.xt.algorithm.designpattern.abstractfactory;

import com.xt.algorithm.designpattern.abstractfactory.color.ColorFactory;
import com.xt.algorithm.designpattern.abstractfactory.shape.ShapeFactory;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:47
 */
public class FactoryProfucer {

  public static AbstractFactory getFactory(String choice) {
    if (choice.equalsIgnoreCase("SHAPE")) {
      return new ShapeFactory();
    } else if (choice.equalsIgnoreCase("COLOR")) {
      return new ColorFactory();
    }
    return null;
  }

}
