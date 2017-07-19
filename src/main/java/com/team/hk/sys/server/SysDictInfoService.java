package com.team.hk.sys.server;

import com.team.hk.sys.entity.SysDictInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统字典信息Service接口
 */
public interface SysDictInfoService {

    /**
     * 获得系统字典信息（通过分页)
     *
     * @return List<SysDictInfo>
     */
    List<SysDictInfo> getAllSysDictInfoByPageService(SysDictInfo sysDictInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统字典信息数量
     *
     * @return List<SysDictInfo>
     */
    int getAllSysDictInfoCountByPageService(SysDictInfo sysDictInfo, Long pageNo, Long pageSize);

    /**
     * 获得系统字典信息
     *
     * @return List<SysDictInfo>
     */
    List<SysDictInfo> getAllSysDictInfoService(SysDictInfo sysDictInfo);

    /**
     * 增加系统字典信息
     *
     * @param sysDictInfo 系统字典实体
     * @return rowsAffected
     */
    int addSysDictInfoService(SysDictInfo sysDictInfo);

    /**
     * 修改系统字典信息
     *
     * @param sysDictInfo 系统字典实体
     * @return rowsAffected
     */
    int updateSysDictInfoService(SysDictInfo sysDictInfo);

    /**
     * 删除一条系统字典信息
     *
     * @param id 系统字典ID
     * @return rowsAffected
     */
    int deleteSysDictInfoByIdService(Long id);

    /**
     * 删除多条系统字典信息
     *
     * @param id 系统字典ID
     * @return rowsAffected
     */
    int deleteSysDictInfoByIdsService(List<Long> id);
}
