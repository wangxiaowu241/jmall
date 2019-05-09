package com.xt.algorithm.designpattern.decorator.demo2;

import com.xt.algorithm.designpattern.decorator.demo2.decorator.Milk;
import com.xt.algorithm.designpattern.decorator.demo2.decorator.Sugar;
import com.xt.algorithm.designpattern.decorator.demo2.drink.Drink;
import com.xt.algorithm.designpattern.decorator.demo2.drink.LatteCoffee;

/**
 * 装饰模式 test
 *
 * 例子：
 * <p/>
 * 咖啡是一种饮品，咖啡种类有拿铁、摩卡、卡布奇诺等。 咖啡可以加调料，糖、牛奶等，假设加调料收费。
 * <p/>
 * 那么如何解决咖啡加调料的问题。 可以每种组合方式都建一个类，但是这种方式解决不了加多个相同调料的问题，比如加两包糖
 * <p/>
 * 使用装饰模式来解决这个问题。 咖啡的核心抽取出来：拿铁、摩卡、卡布奇诺；装饰点：糖、牛奶
 * <p/>
 *
 * @author wangxiaoteng
 * @date 2019/5/9 10:24
 */
public class DecoratorDesignTest {

  public static void main(String[] args) {

    //加两份糖，一份牛奶的摩卡
    Drink firstDrink = new Sugar(new Milk(new Milk(new LatteCoffee())));
    System.out.println(firstDrink.getDescription() + "-" + firstDrink.cost());

    //一份糖，一份牛奶的拿铁
    Drink secondDrink = new Sugar(new Milk(new LatteCoffee()));
    System.out.println(secondDrink.getDescription() + "-" + secondDrink.cost());
  }
}
