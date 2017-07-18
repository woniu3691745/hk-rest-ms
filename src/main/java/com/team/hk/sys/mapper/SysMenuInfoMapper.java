package com.team.hk.sys.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.sys.entity.SysMenuInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统菜单信息mapper接口
 */
public interface SysMenuInfoMapper extends CommonMapper<SysMenuInfo> {

    /**
     * 删除多条
     *
     * @param id 系统菜单信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);
}
