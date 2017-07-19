package com.team.hk.sys.contorller;

import com.team.hk.sys.entity.SysUserInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统用户信息接口
 */
public interface SysUserInfoController {

    /**
     * 获得系统用户信息（通过分页）
     *
     * @param sysUserInfo 用户信息entity
     * @param pageNo      页数
     * @param pageSize    数量
     * @return List<SysUserInfo>
     * >
     */
    List<SysUserInfo> getAllSysUserInfoByPage(SysUserInfo sysUserInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统用户信息
     *
     * @param sysUserInfo 用户信息entity
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> getAllSysUserInfo(SysUserInfo sysUserInfo);

    /**
     * 增加系统用户
     *
     * @param sysUserInfo 系统用户实体
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> addSysUserInfo(SysUserInfo sysUserInfo);

    /**
     * 修改系统用户
     *
     * @param sysUserInfo 系统用户实体
     * @return rowsAffected
     */
    int updateSysUserInfo(SysUserInfo sysUserInfo);

    /**
     * 删除一个系统用户
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteSysUserInfoById(Long id);

    /**
     * 删除多个系统用户
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteSysUserInfoByIds(List<Long> id);
}
