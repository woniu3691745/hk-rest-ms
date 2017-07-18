package com.team.hk.storeInfo.controller;

import com.team.hk.menuInfo.entity.MenuInfo;
import com.team.hk.storeInfo.entity.StoreInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/8.
 * 门店信息接口
 */
public interface StoreInfoController {

    /**
     * 获得菜单信息（通过分页）
     *
     * @return List<storeInfo
     * >
     */
    List<StoreInfo> getAllStoreInfoByPage(StoreInfo storeInfo, Long pageNo, Long pageSize);

    /**
     * 获得菜单信息
     *
     * @return List<storeInfo>
     */
    List<StoreInfo> getAllStoreInfo(Long id);

    /**
     * 增加菜单
     *
     * @param storeInfo 菜单实体
     * @return rowsAffected
     */
    int addStoreInfo(StoreInfo storeInfo);

    /**
     * 修改菜单
     *
     * @param storeInfo 菜单实体
     * @return rowsAffected
     */
    int updateStoreInfo(StoreInfo storeInfo);

    /**
     * 删除一个菜单
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteStoreInfoById(Long id);

    /**
     * 删除多个菜单
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteStoreInfoByIds(List<Long> id);
}
