package com.xt.algorithm.designpattern.builder;

/**
 * 老板-导演、指挥者
 *
 * @author wangxiaoteng
 * @date 2019/4/30 15:25
 */
public class Director {


  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public Computer createComputer(String cpu, String mainBoard, String memory, String hardDisk) {
    builder.setCpu(cpu);
    builder.setHardDisk(hardDisk);
    builder.setMainBoard(mainBoard);
    builder.setMemory(memory);
    return builder.build();
  }
}
