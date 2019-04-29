package com.xt.algorithm.designpattern.abstractfactory.shape;

import com.xt.algorithm.designpattern.abstractfactory.AbstractFactory;
import com.xt.algorithm.designpattern.abstractfactory.color.Color;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:41
 */
public class ShapeFactory extends AbstractFactory {

  @Override
  public Shape getShape(String shapeType) {
    if (null == shapeType) {
      return null;
    } else if ("CIRCLE".equals(shapeType)) {
      return new Circle();
    } else if ("RECTANGLE".equals(shapeType)) {
      return new Rectangle();
    } else if ("SQUARE".equals(shapeType)) {
      return new Square();
    }
    return null;
  }

  @Override
  public Color getColor(String color) {
    return null;
  }
}
