package com.team.hk.storeInfo.entity;

/**
 * Created by lidongliang on 2017/7/24.
 * 用户门店信息实体
 */
public class StoreUserInfo {

    private long userId;        // 用户ID
    private long storeId;       // 门店ID

    public StoreUserInfo() {
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "StoreUserInfo{" +
                "userId=" + userId +
                ", storeId=" + storeId +
                '}';
    }
}
