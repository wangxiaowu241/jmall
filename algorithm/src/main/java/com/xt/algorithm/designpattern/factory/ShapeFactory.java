package com.xt.algorithm.designpattern.factory;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:26
 */
public class ShapeFactory {

  public Shape getShapeByType(String shapeType) {

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
}
