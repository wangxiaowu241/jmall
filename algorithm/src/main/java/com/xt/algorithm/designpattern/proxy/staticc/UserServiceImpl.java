package com.xt.algorithm.designpattern.proxy.staticc;

/**
 * @author wangxiaoteng
 * @date 2019/5/8 20:53
 */
public class UserServiceImpl implements UserService {

  @Override
  public void save() {
    System.out.println("保存数据成功！");
  }
}
