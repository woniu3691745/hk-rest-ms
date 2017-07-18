package com.team.hk.tableInfo.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.tableInfo.entity.TableInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息mapper接口
 */
public interface TableInfoMapper extends CommonMapper<TableInfo> {

    /**
     * 删除多条
     *
     * @param id 桌子信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);
}
