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

    /**
     * 获得全部数据（分页）- user角色用
     *
     * @param sysUserInfo 系统用户实体
     * @return 系统用户信息
     */
    List<SysUserInfo> userListByPage(SysUserInfo sysUserInfo);

    /**
     * 获得全部数据数量 - user角色用
     *
     * @param sysUserInfo 系统用户实体
     * @return 记录条数
     */
    int userListCountByPage(SysUserInfo sysUserInfo);

    /**
     * 删除角色是boss下全部用户
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteByIdChild(Long id);

    /**
     * 删除角色是boss下全部用户
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteByIdsChild(List<Long> id);

}
