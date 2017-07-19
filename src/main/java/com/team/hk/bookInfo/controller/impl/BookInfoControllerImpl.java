package com.team.hk.bookInfo.controller.impl;

import com.team.hk.bookInfo.controller.BookInfoController;
import com.team.hk.bookInfo.entity.BookInfo;
import com.team.hk.bookInfo.service.BookInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 * 预约信息实现类
 */
@Controller
@RequestMapping("/api//book")
public class BookInfoControllerImpl implements BookInfoController {

    private static Logger logger = Logger.getLogger(BookInfoControllerImpl.class);

    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 获得预约信息（通过分页）
     *
     * @param bookInfo 预约entity
     * @param pageNo   页数
     * @param pageSize 数量
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<BookInfo> getAllBookInfoByPage(@RequestBody BookInfo bookInfo, @PathVariable("pageNo") Long pageNo,
                                               @PathVariable("pageSize") Long pageSize) {
        List list = new ArrayList();
        List<BookInfo> menuInfos = bookInfoService.getAllBookInfoByPageService(bookInfo, pageNo, pageSize);
        int count = bookInfoService.getAllBookInfoCountByPageService(bookInfo, pageNo, pageSize);
        list.add(menuInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得预约信息
     *
     * @param bookInfo 预约entity
     * @return List<BookInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<BookInfo> getAllBookInfo(@RequestBody BookInfo bookInfo) {
        return bookInfoService.getAllBookInfoService(bookInfo);
    }

    /**
     * 增加预约信息
     *
     * @param bookInfo 预约entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public int addBookInfo(@RequestBody BookInfo bookInfo) {
        return bookInfoService.addBookInfoService(bookInfo);
    }

    /**
     * 修改预约
     *
     * @param bookInfo 预约entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateBookInfo(@RequestBody BookInfo bookInfo) {
        return bookInfoService.updateBookInfoService(bookInfo);
    }

    /**
     * 删除一个预约
     *
     * @param bookId 预约ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.DELETE)
    @Override
    public int deleteBookInfoById(@PathVariable("bookId") Long bookId) {
        return bookInfoService.deleteBookInfoByIdService(bookId);
    }

    /**
     * 删除多个预约
     *
     * @param bookId 预约ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteBookInfoByIds(@PathVariable("bookId") List<Long> bookId) {
        return bookInfoService.deleteBookInfoByIdsService(bookId);
    }
}
