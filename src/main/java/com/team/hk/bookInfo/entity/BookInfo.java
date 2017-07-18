package com.team.hk.bookInfo.entity;

import com.team.hk.common.CommonEntity;

import java.util.Date;

/**
 * Created by lidongliang on 2017/7/10.
 * 预约实体
 */
public class BookInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long bookId;        // 预约ID
    private String bookName;    // 预约人
    private Long bookPhone;     // 预约电话
    private Date bookTime;      // 预约时间
    private Long storeId;       // 预约餐厅编号
    private Long tableId;       // 预约桌子编号

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getBookPhone() {
        return bookPhone;
    }

    public void setBookPhone(Long bookPhone) {
        this.bookPhone = bookPhone;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public BookInfo() {
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPhone=" + bookPhone +
                ", bookTime=" + bookTime +
                ", storeId=" + storeId +
                ", tableId=" + tableId +
                '}';
    }
}
