package com.xt.algorithm.designpattern.builder;

/**
 * 装电脑的步骤-抽象的建造者
 *
 * @author wangxiaoteng
 * @date 2019/4/30 14:56
 */
public interface Builder {

  /**
   * 安装CPU
   */
  void setCpu(String cpu);


  /**
   * 安装主板
   */
  void setMainBoard(String mainBoard);

  /**
   * 安装硬盘
   */
  void setHardDisk(String hardDisk);

  /**
   * 安装内存
   */
  void setMemory(String memory);

  /**
   * 构造
   */
  Computer build();
}