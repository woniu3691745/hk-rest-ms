package com.team.hk.bookInfo.controller;


import com.team.hk.bookInfo.entity.BookInfo;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 * 预约信息接口
 */
public interface BookInfoController {

    /**
     * 获得预约信息（通过分页）
     *
     * @param bookInfo 预约entity
     * @param pageNo   页数
     * @param pageSize 数量
     * @return List<BookInfo>
     */
    List<BookInfo> getAllBookInfoByPage(BookInfo bookInfo, Long pageNo, Long pageSize);

    /**
     * 获得预约信息
     *
     * @param bookInfo 预约entity
     * @return List<BookInfo>
     */
    List<BookInfo> getAllBookInfo(BookInfo bookInfo);

    /**
     * 增加预约
     *
     * @param bookInfo 预约实体
     * @return rowsAffected
     */
    int addBookInfo(BookInfo bookInfo);

    /**
     * 修改预约
     *
     * @param bookInfo 预约实体
     * @return rowsAffected
     */
    int updateBookInfo(BookInfo bookInfo);

    /**
     * 删除一个预约
     *
     * @param id 预约ID
     * @return rowsAffected
     */
    int deleteBookInfoById(Long id);

    /**
     * 删除多个预约
     *
     * @param id 预约ID
     * @return rowsAffected
     */
    int deleteBookInfoByIds(List<Long> id);
}
