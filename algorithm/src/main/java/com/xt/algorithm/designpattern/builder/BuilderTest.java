package com.xt.algorithm.designpattern.builder;

/**
 * <p/>
 * 建造者模式：通过使用多个简单的对象一个一个构造成复杂的对象。
 * <p/>
 * 意图：将一个复杂对象的构建与其表示相分离，使得相同的构建过程可以创建不同的表示
 * <p/>
 * 主要解决在软件系统中，有时候面临一个复杂对象的创建，通常由其各个子部分通过一定的算法组成。由于需求的变化， 这个复杂对象的各个部分经常面临着剧烈的变化，但将他们组装在一起却很稳定。
 * <p/>
 *
 * @author wangxiaoteng
 * @date 2019/4/30 15:27
 */
public class BuilderTest {

  public static void main(String[] args) {

    ConcreteBuilder concreteBuilder = new ConcreteBuilder();
    Director director = new Director(concreteBuilder);
    Computer computer = director.createComputer(
        "intel core i7",
        "huashuo mainboard",
        "Samsung 16G ",
        "kingston 512G SSD");
    System.out.println(
        "小明这台电脑使用的是：\n" + computer.getMainBoard() + " 主板\n" + computer.getCpu() + " CPU\n" + computer.getHardDisk()
            + "硬盘\n" + computer.getMainBoard() + " 内存\n");
  }
}
