package com.team.hk.sys.contorller;

import com.team.hk.sys.entity.SysDictInfo;
import com.team.hk.sys.entity.SysUserInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统字典信息接口
 */
public interface SysDictInfoController {

    /**
     * 获得系统字典信息（通过分页）
     *
     * @param sysDictInfo 系统字典entity
     * @param pageNo      页数
     * @param pageSize    数量
     * @return List<SysDictInfo>
     */
    List<SysDictInfo> getAllSysDictInfoByPage(SysDictInfo sysDictInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统字典信息
     *
     * @param sysDictInfo 系统字典entity
     * @return List<SysDictInfo>
     */
    List<SysDictInfo> getAllSysDictInfo(SysDictInfo sysDictInfo);

    /**
     * 增加系统字典
     *
     * @param sysDictInfo 系统字典实体
     * @return rowsAffected
     */
    int addSysDictInfo(SysDictInfo sysDictInfo);

    /**
     * 修改系统字典
     *
     * @param sysDictInfo 系统字典实体
     * @return rowsAffected
     */
    int updateSysDictInfo(SysDictInfo sysDictInfo);

    /**
     * 删除一个系统字典
     *
     * @param id 系统字典ID
     * @return rowsAffected
     */
    int deleteSysDictInfoById(Long id);

    /**
     * 删除多个系统字典
     *
     * @param id 系统字典ID
     * @return rowsAffected
     */
    int deleteSysDictInfoByIds(List<Long> id);
}
