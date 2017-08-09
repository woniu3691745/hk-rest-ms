package com.team.hk.storeInfo.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.storeInfo.entity.StoreImg;
import com.team.hk.storeInfo.entity.StoreInfo;
import com.team.hk.storeInfo.entity.StoreUserInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/8.
 * 菜单信息mapper接口
 */
public interface StoreInfoMapper extends CommonMapper<StoreInfo> {

    /**
     * 删除多条
     *
     * @param id 门店信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);

    /**
     * 添加用户门店信息
     *
     * @param storeUserInfo 用户门店信息实体
     * @return rowsAffected
     */
    int addStoreUserInfo(StoreUserInfo storeUserInfo);

    /**
     * 删除一条记录
     *
     * @param id 门店信息ID
     * @return rowsAffected
     */
    int deleteByIdOne(Long id);

    /**
     * 删除多条
     *
     * @param id 门店信息ID
     * @return rowsAffected
     */
    int deleteByIdsOne(List<Long> id);

    /**
     * 通过用户ID获得门店ID
     *
     * @param id 用户ID
     * @return 门店ID
     */
    Long getStoreIdbyUser(Long id);

    /**
     * 添加门店图片
     *
     * @param storeImg 门店图片
     * @return rowsAffected
     */
    int addStoreImg(List<StoreImg> storeImg);

    /**
     * 获得门店图片
     *
     * @param id 门店ID
     * @return 门店图片
     */
    List<String> getStoreImg(Long id);

    /**
     * 删除门店图片
     *
     * @param imgUrl 文件路径
     * @return rowsAffected
     */
    int deleteStoreImg(String imgUrl);
}
