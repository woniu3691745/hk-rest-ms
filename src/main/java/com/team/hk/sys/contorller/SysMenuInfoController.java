package com.team.hk.sys.contorller;

import com.team.hk.sys.entity.SysMenuInfo;
import com.team.hk.tableInfo.entity.TableInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统菜单信息接口
 */
public interface SysMenuInfoController {

    /**
     * 获得系统菜单信息（通过分页）
     * @return List<SysMenuInfo>
     * >
     */
    List<SysMenuInfo> getAllSysMenuInfoByPage(SysMenuInfo sysMenuInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统菜单信息
     * @return List<SysMenuInfo>
     */
    List<SysMenuInfo> getAllSysMenuInfo(Long id);

    /**
     * 增加系统菜单
     * @param sysMenuInfo 系统菜单实体
     * @return 1
     */
    int addSysMenuInfo(SysMenuInfo sysMenuInfo);

    /**
     * 修改系统菜单
     * @param sysMenuInfo 系统菜单实体
     * @return 1
     */
    int updateSysMenuInfo(SysMenuInfo sysMenuInfo);

    /**
     * 删除一个系统菜单
     * @param id 系统菜单ID
     * @return 1
     */
    int deleteSysMenuInfoById(Long id);

    /**
     * 删除多个系统菜单
     * @param id 系统菜单ID
     * @return 1
     */
    int deleteSysMenuInfoByIds(List<Long> id);
}
