package com.team.hk.sys.mapper;

import com.team.hk.common.CommonMapper;
import com.team.hk.sys.entity.SysDictInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统字典信息mapper接口
 */
public interface SysDictInfoMapper extends CommonMapper<SysDictInfo> {

    /**
     * 删除多条
     *
     * @param id 系统字典ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);
}
