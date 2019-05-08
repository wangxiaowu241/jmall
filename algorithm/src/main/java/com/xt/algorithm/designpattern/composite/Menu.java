package com.xt.algorithm.designpattern.composite;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单项
 *
 * @author wangxiaoteng
 * @date 2019/5/7 16:03
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {

  /**
   * 菜单名称
   */
  private String name;

  /**
   * 子菜单
   */
  private List<Menu> subMenuList;

}
