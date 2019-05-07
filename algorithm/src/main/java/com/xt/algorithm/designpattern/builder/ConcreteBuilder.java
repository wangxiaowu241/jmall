package com.xt.algorithm.designpattern.builder;

/**
 * 装机人员-具体的建造者
 *
 * @author wangxiaoteng
 * @date 2019/4/30 14:58
 */
public class ConcreteBuilder implements Builder {

  private Computer computer = new Computer();


  @Override
  public void setCpu(String cpu) {
    computer.setCpu(cpu);
  }

  @Override
  public void setMainBoard(String mainBoard) {
    computer.setMainBoard(mainBoard);
  }

  @Override
  public void setHardDisk(String hardDisk) {
    computer.setHardDisk(hardDisk);
  }

  @Override
  public void setMemory(String memory) {
    computer.setMemory(memory);
  }

  @Override
  public Computer build() {
    return computer;
  }
}
