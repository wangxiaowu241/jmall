package com.xt.algorithm.designpattern.adapter;

import java.util.List;

/**
 * 只能播放普通MP3格式的音乐
 *
 * @author wangxiaoteng
 * @date 2019/5/5 16:17
 */
public class AudioPlayer implements MediaPlayer {

  private AudioAdapter audioAdapter = new AudioAdapter();

  /**
   * 播放
   */
  @Override
  public void play(String audioType, String fileName) {

    if ("mp3".equalsIgnoreCase(audioType)) {

      System.out.println("播放MP3格式的音乐。。。");
    } else if (List.of("mp4", "vlc").contains(audioType)) {
      audioAdapter.play(audioType, fileName);
    }
  }
}
