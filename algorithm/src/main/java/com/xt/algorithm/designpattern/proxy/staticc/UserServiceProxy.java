package com.xt.algorithm.designpattern.proxy.staticc;

/**
 * @author wangxiaoteng
 * @date 2019/5/8 20:54
 */
public class UserServiceProxy implements UserService {

  private UserService userService;

  public UserServiceProxy(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void save() {
    userService.save();
  }

  private void checkAuth(){
    System.out.println("校验权限通过。。。可以保存数据");
  }
}
