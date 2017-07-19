package com.team.hk.bookInfo.service.impl;

import com.team.hk.bookInfo.entity.BookInfo;
import com.team.hk.bookInfo.mapper.BookInfoMapper;
import com.team.hk.bookInfo.service.BookInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 * 预约信息Service实现类
 */
@Transactional
@Service
public class BookInfoServiceImpl implements BookInfoService {

    private static Logger logger = Logger.getLogger(BookInfoServiceImpl.class);

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> getAllBookInfoByPageService(BookInfo bookInfo, Long pageNo, Long pageSize) {
        bookInfo.setPageNo(pageNo);
        bookInfo.setPageSize(pageSize);
        return bookInfoMapper.listByPage(bookInfo);
    }

    @Override
    public int getAllBookInfoCountByPageService(BookInfo bookInfo, Long pageNo, Long pageSize) {
        bookInfo.setPageNo(pageNo);
        bookInfo.setPageSize(pageSize);
        return bookInfoMapper.listCountByPage(bookInfo);
    }

    @Override
    public List<BookInfo> getAllBookInfoService(BookInfo bookInfo) {
        return bookInfoMapper.list(bookInfo);
    }

    @Override
    public List<BookInfo> addBookInfoService(BookInfo bookInfo) {
        bookInfoMapper.add(bookInfo);
        if (bookInfo.getBookId() != null) {
            logger.debug("添加预定信息成功,返回BOOKID : " + bookInfo.getBookId());
            BookInfo bi = new BookInfo();
            bookInfo.setBookId(bi.getBookId());
            return bookInfoMapper.list(bi);
        } else {
            logger.error("添加预定信息失败,返回BOOKID : " + bookInfo.getBookId());
            return null;
        }
    }

    @Override
    public int updateBookInfoService(BookInfo bookInfo) {
        return bookInfoMapper.update(bookInfo);
    }

    @Override
    public int deleteBookInfoByIdService(Long bookId) {
        return bookInfoMapper.deleteById(bookId);
    }

    @Override
    public int deleteBookInfoByIdsService(List<Long> bookId) {
        return bookInfoMapper.deleteByIds(bookId);
    }
}
