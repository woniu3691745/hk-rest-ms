package com.team.hk.sys.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.sys.entity.SysUserInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统用户信息mapper接口
 */
public interface SysUserInfoMapper extends CommonMapper<SysUserInfo> {

    /**
     * 删除多条
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);
}
