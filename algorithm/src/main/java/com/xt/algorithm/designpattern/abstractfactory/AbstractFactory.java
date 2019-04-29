package com.xt.algorithm.designpattern.abstractfactory;

import com.xt.algorithm.designpattern.abstractfactory.color.Color;
import com.xt.algorithm.designpattern.abstractfactory.shape.Shape;

/**
 * @author wangxiaoteng
 * @date 2019/4/29 17:40
 */
public abstract class AbstractFactory {

  public abstract Shape getShape(String shape);

  public abstract Color getColor(String color);
}
