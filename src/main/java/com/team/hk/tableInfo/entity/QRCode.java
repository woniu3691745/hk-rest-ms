package com.team.hk.tableInfo.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by lidongliang on 2017/8/16.
 * 二维码信息
 */
public class QRCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String base64Img;   // 桌子二维码
    private String tableName;     // 桌子名字

    public String getBase64Img() {
        return base64Img;
    }

    public void setBase64Img(String base64Img) {
        this.base64Img = base64Img;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "QRCode{" +
                "base64Img='" + base64Img + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }

    public QRCode() {
    }
}
