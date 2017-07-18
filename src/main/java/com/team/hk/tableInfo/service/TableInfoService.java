package com.team.hk.tableInfo.service;


import com.team.hk.tableInfo.entity.TableInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息Service接口
 */
public interface TableInfoService {

    /**
     * 获得桌子信息（通过分页)
     *
     * @return List<TableInfo>
     */
    List<TableInfo> getAllTableInfoByPageService(TableInfo tableInfo, Long pageNo, Long pageSize);

    /**
     * 获得桌子信息数量
     *
     * @return List<TableInfo>
     */
    int getAllTableInfoCountByPageService(TableInfo tableInfo, Long pageNo, Long pageSize);

    /**
     * 获得桌子信息
     *
     * @return List<TableInfo>
     */
    List<TableInfo> getAllTableInfoService(TableInfo tableInfo);

    /**
     * 增加桌子信息
     *
     * @param tableInfo 桌子实体
     * @return rowsAffected
     */
    int addTableInfoService(TableInfo tableInfo);

    /**
     * 修改桌子信息
     *
     * @param tableInfo 桌子实体
     * @return rowsAffected
     */
    int updateTableInfoService(TableInfo tableInfo);

    /**
     * 删除一条桌子信息
     *
     * @param id 桌子ID
     * @return rowsAffected
     */
    int deleteTableInfoByIdService(Long id);

    /**
     * 删除多条桌子信息
     *
     * @param id 桌子ID
     * @return rowsAffected
     */
    int deleteTableInfoByIdsService(List<Long> id);
}
