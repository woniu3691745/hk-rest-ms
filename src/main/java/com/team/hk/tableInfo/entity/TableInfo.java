package com.team.hk.tableInfo.entity;

import com.team.hk.common.CommonEntity;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息实体
 */
public class TableInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long tableId;
    private Long storeId;
    private int tableStatus;
    private String tableDescription;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableId=" + tableId +
                ", storeId=" + storeId +
                ", tableStatus=" + tableStatus +
                ", tableDescription='" + tableDescription + '\'' +
                '}';
    }

    public TableInfo() {
    }
}
