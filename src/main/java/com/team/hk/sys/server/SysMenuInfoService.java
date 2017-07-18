package com.team.hk.sys.server;

import com.team.hk.sys.entity.SysMenuInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统菜单信息Service接口
 */
public interface SysMenuInfoService {

    /**
     * 获得系统菜单信息（通过分页)
     * @return List<SysMenuInfo>
     */
    List<SysMenuInfo> getAllSysMenuInfoByPageService(SysMenuInfo sysMenuInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统菜单信息数量
     * @return List<SysMenuInfo>
     */
    int getAllSysMenuInfoCountByPageService(SysMenuInfo sysMenuInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统菜单信息
     * @return List<SysMenuInfo>
     */
    List<SysMenuInfo> getAllSysMenuInfoService(SysMenuInfo sysMenuInfo);

    /**
     * 增加系统菜单信息
     * @param sysMenuInfo 系统菜单实体
     * @return 1
     */
    int addSysMenuInfoService(SysMenuInfo sysMenuInfo);

    /**
     * 修改系统菜单信息
     * @param sysMenuInfo 系统菜单实体
     * @return 1
     */
    int updateSysMenuInfoService(SysMenuInfo sysMenuInfo);

    /**
     * 删除一条系统菜单信息
     * @param id 系统菜单ID
     * @return 1
     */
    int deleteSysMenuInfoByIdService(Long id);

    /**
     * 删除多条系统菜单信息
     * @param id 系统菜单ID
     * @return 1
     */
    int deleteSysMenuInfoByIdsService(List<Long> id);
}
