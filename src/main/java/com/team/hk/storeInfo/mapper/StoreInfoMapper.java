package com.team.hk.storeInfo.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.storeInfo.entity.StoreInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/8.
 * 菜单信息mapper接口
 */
public interface StoreInfoMapper extends CommonMapper<StoreInfo> {

    /**
     * 删除多条
     *
     * @param id 菜单信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);
}
