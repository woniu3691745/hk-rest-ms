package com.team.hk.storeInfo.controller;

import com.team.hk.storeInfo.entity.StoreImg;
import com.team.hk.storeInfo.entity.StoreInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/8.
 * 门店信息接口
 */
public interface StoreInfoController {

    /**
     * 获得门店信息（通过分页）
     *
     * @param storeInfo 门店entity
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<storeInfo>
     *
     */
    List<StoreInfo> getAllStoreInfoByPage(StoreInfo storeInfo, Long pageNo, Long pageSize, HttpServletRequest request);

    /**
     * 获得门店信息
     *
     * @param storeInfo 门店entity
     * @return List<storeInfo>
     */
    List<StoreInfo> getAllStoreInfo(StoreInfo storeInfo, HttpServletRequest request);

    /**
     * 增加门店
     *
     * @param storeInfo 门店entity
     * @return List<StoreInfo>
     */
    List<StoreInfo> addStoreInfo(StoreInfo storeInfo, HttpServletRequest request);

    /**
     * 修改门店
     *
     * @param storeInfo 门店实体
     * @return rowsAffected
     */
    int updateStoreInfo(StoreInfo storeInfo);

    /**
     * 删除一个门店
     *
     * @param id 门店ID
     * @return rowsAffected
     */
    int deleteStoreInfoById(Long id);

    /**
     * 删除多个门店
     *
     * @param id 门店ID
     * @return rowsAffected
     */
    int deleteStoreInfoByIds(List<Long> id);

    /**
     * 删除门店图片
     *
     * @param storeImg 文件路径
     * @return rowsAffected
     */
    int deleteStoreImg(StoreImg storeImg);
}
