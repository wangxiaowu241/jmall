package com.xt.algorithm.designpattern.adapter;

/**
 * 媒体播放器接口-播放普通MP3格式的音乐
 *
 * @author wangxiaoteng
 * @date 2019/5/5 16:17
 */
public interface MediaPlayer {

  /**
   * 播放
   */
  void play(String audioType, String fileName);
}
