package com.team.hk.menuInfo.controller;

import com.team.hk.menuInfo.entity.MenuInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/7.
 * 菜单信息接口
 */
public interface MenuInfoController {

    /**
     * 获得菜单信息（通过分页）
     *
     * @return List<MenuInfo>
     */
    List<MenuInfo> getAllMenuInfoByPage(MenuInfo menuInfo, Long pageNo, Long pageSize);

    /**
     * 获得菜单信息
     *
     * @return List<MenuInfo>
     */
    List<MenuInfo> getAllMenuInfo(Long id);

    /**
     * 增加菜单
     *
     * @param menuInfo 菜单实体
     * @return rowsAffected
     */
    int addMenuInfo(MenuInfo menuInfo);

    /**
     * 修改菜单
     *
     * @param menuInfo 菜单实体
     * @return rowsAffected
     */
    int updateMenuInfo(MenuInfo menuInfo);

    /**
     * 删除一个菜单
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteMenuInfoById(Long id);

    /**
     * 删除多个菜单
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteMenuInfoByIds(List<Long> id);
}
