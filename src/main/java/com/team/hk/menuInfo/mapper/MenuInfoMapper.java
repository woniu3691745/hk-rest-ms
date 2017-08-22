package com.team.hk.menuInfo.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.menuInfo.entity.MenuInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/7.
 * 菜单信息mapper接口
 */
public interface MenuInfoMapper extends CommonMapper<MenuInfo> {

    /**
     * 删除多条
     *
     * @param id 菜单信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);

    /**
     * 通过菜品种类获得菜单信息
     *
     * @return List<MenuInfo>
     */
    List<MenuInfo> menuInfoByCategory(Long storeId);
}
