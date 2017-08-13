package com.team.hk.sys.entity;

import java.io.Serializable;

/**
 * Created by lidongliang on 2017/7/18.
 * 登陆后返回实体信息
 */
public class SysUserInfoByLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;        // 用户ID
    private String userName;    // 用户名称
    private String userRole;    // 用户角色
    private Long storeId;       // 门店ID
    private String storeLogo;   // 门店logo

    public SysUserInfoByLogin() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    @Override
    public String toString() {
        return "SysUserInfoByLogin{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", storeId=" + storeId +
                ", storeLogo='" + storeLogo + '\'' +
                '}';
    }
}
