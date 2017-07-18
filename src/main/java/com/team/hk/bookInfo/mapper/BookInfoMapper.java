package com.team.hk.bookInfo.mapper;

import com.team.hk.bookInfo.entity.BookInfo;
import com.team.hk.common.CommonMapper;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 * 预约信息mapper接口
 */
public interface BookInfoMapper extends CommonMapper<BookInfo> {

    /**
     * 删除多条
     *
     * @param id 预约信息ID
     * @return rowsAffected
     */
    int deleteByIds(List<Long> id);
}
