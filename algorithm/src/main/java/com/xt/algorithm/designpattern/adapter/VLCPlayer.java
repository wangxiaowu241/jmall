package com.xt.algorithm.designpattern.adapter;

/**
 * 播放VLC格式的音乐
 *
 * @author wangxiaoteng
 * @date 2019/5/5 16:36
 */
public class VLCPlayer implements AdvancedAudioPlayer {

  @Override
  public void play() {
    System.out.println("播放VLC格式的音乐");
  }
}
