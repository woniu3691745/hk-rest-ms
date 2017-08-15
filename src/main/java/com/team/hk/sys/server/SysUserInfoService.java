package com.team.hk.sys.server;

import com.team.hk.sys.entity.SysUserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统用户信息Service接口
 */
public interface SysUserInfoService {

    /**
     * 获得系统用户信息（通过分页)
     *
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> getAllSysUserInfoByPageService(SysUserInfo sysUserInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统用户信息数量
     *
     * @return List<SysUserInfo>
     */
    int getAllSysUserInfoCountByPageService(SysUserInfo sysUserInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统用户信息
     *
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> getAllSysUserInfoService(SysUserInfo sysUserInfo);

    /**
     * 增加系统用户信息
     *
     * @param sysUserInfo 系统用户实体
     * @return List<SysUserInfo>
     */
    List<SysUserInfo> addSysUserInfoService(SysUserInfo sysUserInfo);

    /**
     * 修改系统用户信息
     *
     * @param sysUserInfo 系统用户实体
     * @return rowsAffected
     */
    int updateSysUserInfoService(SysUserInfo sysUserInfo);

    /**
     * 删除一条系统用户信息
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteSysUserInfoByIdService(Long id, HttpServletRequest request);

    /**
     * 删除多条系统用户信息
     *
     * @param id 系统用户ID
     * @return rowsAffected
     */
    int deleteSysUserInfoByIdsService(List<Long> id, HttpServletRequest request);
}
