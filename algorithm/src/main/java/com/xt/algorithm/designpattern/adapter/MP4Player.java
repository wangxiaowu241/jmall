package com.xt.algorithm.designpattern.adapter;

/**
 * 高级播放器
 *
 * @author wangxiaoteng
 * @date 2019/5/5 16:26
 */
public class MP4Player implements AdvancedAudioPlayer {

  @Override
  public void play() {
    System.out.println("播放MP4");
  }

}
