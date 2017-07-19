package com.team.hk.bookInfo.service;


import com.team.hk.bookInfo.entity.BookInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 * 预约信息Service接口
 */
public interface BookInfoService {
    /**
     * 获得预约信息（通过分页)
     *
     * @return List<BookInfo>
     */
    List<BookInfo> getAllBookInfoByPageService(BookInfo bookInfo, Long pageNo, Long pageSize);

    /**
     * 获得预约信息数量
     *
     * @return List<BookInfo>
     */
    int getAllBookInfoCountByPageService(BookInfo bookInfo, Long pageNo, Long pageSize);

    /**
     * 获得预约信息
     *
     * @return List<BookInfo>
     */
    List<BookInfo> getAllBookInfoService(BookInfo bookInfo);

    /**
     * 增加预约信息
     *
     * @param bookInfo 预约实体
     * @return List<BookInfo>
     */
    List<BookInfo> addBookInfoService(BookInfo bookInfo);

    /**
     * 修改预约信息
     *
     * @param bookInfo 预约实体
     * @return rowsAffected
     */
    int updateBookInfoService(BookInfo bookInfo);

    /**
     * 删除一条预约信息
     *
     * @param id 预约ID
     * @return rowsAffected
     */
    int deleteBookInfoByIdService(Long id);

    /**
     * 删除多条预约信息
     *
     * @param id 预约ID
     * @return rowsAffected
     */
    int deleteBookInfoByIdsService(List<Long> id);
}
