package com.xt.algorithm.designpattern.composite;

import java.util.List;

/**
 * 组合模式demo
 *
 * 意图：模糊了树形结构中复杂元素和简单元素的区别，使得程序可以像简单元素一样处理复杂元素。
 *
 * 关键代码：树枝内部组合该接口，并且含有内部属性 List，里面放 Component。
 *
 * 使用场景：部分、整体场景，如树形菜单，文件、文件夹的管理。
 *
 * @author wangxiaoteng
 * @date 2019/5/7 15:59
 */
public class CompositeDesignTest {

  public static void main(String[] args) {

    //打印所有的菜单项

    Menu thirdMenu1 = new Menu("三级菜单1", null);
    Menu thirdMenu2 = new Menu("三级菜单2", null);
    Menu thirdMenu3 = new Menu("三级菜单3", null);
    Menu thirdMenu4 = new Menu("三级菜单4", null);
    Menu secondMenu1 = new Menu("二级菜单1", List.of(thirdMenu1, thirdMenu2));
    Menu secondMenu2 = new Menu("二级菜单2", List.of(thirdMenu3, thirdMenu4));
    Menu firstMenu = new Menu("一级菜单", List.of(secondMenu1, secondMenu2));

    printAllMenu(firstMenu);
  }

  private static void printAllMenu(Menu menu) {

    Menu currentMenu = menu;
    while (null != currentMenu.getSubMenuList() && !currentMenu.getSubMenuList().isEmpty()) {

      System.out.println("菜单名称为:" + currentMenu.getName());

      for (Menu innerMenu : currentMenu.getSubMenuList()) {
        printAllMenu(innerMenu);
      }
    }

  }
}
