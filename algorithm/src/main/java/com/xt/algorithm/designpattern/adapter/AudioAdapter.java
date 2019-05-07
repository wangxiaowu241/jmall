package com.xt.algorithm.designpattern.adapter;

/**
 * 播放音乐adapter适配器
 *
 * @author wangxiaoteng
 * @date 2019/5/5 16:27
 */
public class AudioAdapter implements MediaPlayer {

  private AdvancedAudioPlayer mp4Player = new MP4Player();
  private AdvancedAudioPlayer vlcPlayer = new VLCPlayer();

  @Override
  public void play(String audioType, String fileName) {

    if ("mp4".equalsIgnoreCase(audioType)) {
      mp4Player.play();
    } else if ("vlc".equalsIgnoreCase(audioType)) {
      vlcPlayer.play();
    }
  }
}
