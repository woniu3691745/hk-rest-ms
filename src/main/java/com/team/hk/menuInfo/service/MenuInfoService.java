package com.team.hk.menuInfo.service;


import com.team.hk.menuInfo.entity.MenuInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/7.
 * 菜单信息Service接口
 */
public interface MenuInfoService {

    /**
     * 获得菜单信息（通过分页)
     *
     * @return List<MenuInfo>
     */
    List<MenuInfo> getAllMenuInfoByPageService(MenuInfo menuInfo, Long pageNo, Long pageSize);

    /**
     * 获得菜单信息数量
     *
     * @return List<MenuInfo>
     */
    int getAllMenuInfoCountByPageService(MenuInfo menuInfo, Long pageNo, Long pageSize);

    /**
     * 获得菜单信息
     *
     * @return List<MenuInfo>
     */
    List<MenuInfo> getAllMenuInfoService(MenuInfo menuInfo);

    /**
     * 增加菜单信息
     *
     * @param menuInfo 菜单实体
     * @return List<MenuInfo>
     */
    List<MenuInfo> addMenuInfoService(MenuInfo menuInfo);

    /**
     * 修改菜单信息
     *
     * @param menuInfo 菜单实体
     * @return rowsAffected
     */
    int updateMenuInfoService(MenuInfo menuInfo);

    /**
     * 删除一条菜单信息
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteMenuInfoByIdService(Long id);

    /**
     * 删除多条菜单信息
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteMenuInfoByIdsService(List<Long> id);
}
