package com.xt.algorithm.designpattern.abstractfactory.color;

import com.xt.algorithm.designpattern.abstractfactory.AbstractFactory;
import com.xt.algorithm.designpattern.abstractfactory.shape.Shape;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:44
 */
public class ColorFactory extends AbstractFactory {

  @Override
  public Shape getShape(String shape) {
    return null;
  }

  @Override
  public Color getColor(String color) {
    if (null == color) {
      return null;
    } else if ("RED".equals(color)) {
      return new Red();
    } else if ("BLUE".equals(color)) {
      return new Blue();
    } else if ("GREEN".equals(color)) {
      return new Green();
    }
    return null;
  }
}
