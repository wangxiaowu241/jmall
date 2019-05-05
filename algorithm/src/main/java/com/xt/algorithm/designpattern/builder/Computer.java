package com.xt.algorithm.designpattern.builder;

import lombok.Data;

/**
 * 电脑-构造的产品类
 *
 * @author wangxiaoteng
 * @date 2019/4/30 14:55
 */
@Data
public class Computer {

  /**
   * CPU
   */
  private String cpu;

  /**
   * 主板
   */
  private String mainBoard;

  /**
   * 内存
   */
  private String memory;

  /**
   * 硬盘
   */
  private String hardDisk;
}
