package com.team.hk.tableInfo.controller;


import com.team.hk.tableInfo.entity.TableInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息接口
 */
public interface TableInfoController {

    /**
     * 获得桌子信息（通过分页）
     *
     * @param tableInfo 桌子entity
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<TableInfo>
     * >
     */
    List<TableInfo> getAllTableInfoByPage(TableInfo tableInfo, Long pageNo, Long pageSize);

    /**
     * 获得桌子信息
     *
     * @param tableInfo 桌子entity
     * @return List<TableInfo>
     */
    List<TableInfo> getAllTableInfo(TableInfo tableInfo);

    /**
     * 增加桌子
     *
     * @param tableInfo 桌子实体
     * @return List<TableInfo>
     */
    List<TableInfo> addTableInfo(TableInfo tableInfo);

    /**
     * 修改桌子
     *
     * @param tableInfo 桌子实体
     * @return rowsAffected
     */
    int updateTableInfo(TableInfo tableInfo);

    /**
     * 删除一个桌子
     *
     * @param id 桌子ID
     * @return rowsAffected
     */
    int deleteTableInfoById(Long id);

    /**
     * 删除多个桌子
     *
     * @param id 桌子ID
     * @return rowsAffected
     */
    int deleteTableInfoByIds(List<Long> id);
}
