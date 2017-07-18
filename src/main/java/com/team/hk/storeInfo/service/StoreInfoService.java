package com.team.hk.storeInfo.service;


import com.team.hk.storeInfo.entity.StoreInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/8.
 * 门店信息Service接口
 */
public interface StoreInfoService {

    /**
     * 获得菜单信息（通过分页)
     *
     * @return List<StoreInfo>
     */
    List<StoreInfo> getAllStoreInfoByPageService(StoreInfo storeInfo, Long pageNo, Long pageSize);

    /**
     * 获得菜单信息数量
     *
     * @return List<StoreInfo>
     */
    int getAllStoreInfoCountByPageService(StoreInfo storeInfo, Long pageNo, Long pageSize);

    /**
     * 获得菜单信息
     *
     * @return List<StoreInfo>
     */
    List<StoreInfo> getAllStoreInfoService(StoreInfo storeInfo);

    /**
     * 增加菜单信息
     *
     * @param storeInfo 菜单实体
     * @return rowsAffected
     */
    int addStoreInfoService(StoreInfo storeInfo);

    /**
     * 修改菜单信息
     *
     * @param storeInfo 菜单实体
     * @return rowsAffected
     */
    int updateStoreInfoService(StoreInfo storeInfo);

    /**
     * 删除一条菜单信息
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteStoreInfoByIdService(Long id);

    /**
     * 删除多条菜单信息
     *
     * @param id 菜单ID
     * @return rowsAffected
     */
    int deleteStoreInfoByIdsService(List<Long> id);
}
