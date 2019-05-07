package com.xt.algorithm.designpattern.adapter;

/**
 * 适配器模式test
 *
 * 适配器模式：作为两个不同接口之间的桥梁，负责加入独立的或者不兼容的接口功能
 *
 * @author wangxiaoteng
 * @date 2019/5/5 16:46
 */
public class AdapterDesignTest {

  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.play("mp3", "枫.mp3");
    audioPlayer.play("mp4", "枫.mp4");
    audioPlayer.play("vlc", "枫.vlc");
  }
}
