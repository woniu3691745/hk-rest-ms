package com.team.hk.sys.entity;

import com.team.hk.common.CommonEntity;

/**
 * Created by lidongliang on 2017/7/18.
 * 系统用户实体
 */
public class SysUserInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String userPassword;
    private Long userPhone;
    private int userSex;
    private String userAddress;
    private String userRole;

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public SysUserInfo() {
    }

    @Override
    public String toString() {
        return "SysUserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone=" + userPhone +
                ", userSex=" + userSex +
                ", userAddress='" + userAddress + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
