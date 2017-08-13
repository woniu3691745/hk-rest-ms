package com.team.hk.storeInfo.entity;

import com.team.hk.common.CommonEntity;

import java.util.Arrays;

/**
 * Created by lidongliang on 2017/7/8.
 * 门店信息实体
 */
public class StoreInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long storeId;               // 餐厅编号
    private String storeName;           // 餐厅名称
    private Long storePhone;            // 订餐电话
    private String storeAddress;        // 餐厅地址
    private String storeAdmin;          // 餐厅负责人
    private String storeDescription;    // 餐厅描述
    private int storeStatus;            // 餐厅状态
    private String storeLogo;           // 餐厅LOGO
    private String storeNotice;         // 餐厅公告
    private int storeType;              // 餐厅类型
    private Float seatCost;             // 茶位费
    private String serviceCost;         // 服务费
    private String storeBusinessAmStartHours;         // 餐厅营业上午营业开始时间
    private String storeBusinessAmEndHours;           // 餐厅营业上午闭店结束时间
    private String storeBusinessPmStartHours;         // 餐厅营业下午营业开始时间
    private String storeBusinessPmEndHours;           // 餐厅营业下午闭店结束时间
    private String storeBusinessDay;                  // 餐厅营业日

    private String[] storeImg;          // 餐厅相片

    private Long userId;                // 用户编号

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(Long storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreAdmin() {
        return storeAdmin;
    }

    public void setStoreAdmin(String storeAdmin) {
        this.storeAdmin = storeAdmin;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public int getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(int storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreNotice() {
        return storeNotice;
    }

    public void setStoreNotice(String storeNotice) {
        this.storeNotice = storeNotice;
    }

    public String[] getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String[] storeImg) {
        this.storeImg = storeImg;
    }

    public int getStoreType() {
        return storeType;
    }

    public void setStoreType(int storeType) {
        this.storeType = storeType;
    }

    public Float getSeatCost() {
        return seatCost;
    }

    public void setSeatCost(Float seatCost) {
        this.seatCost = seatCost;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getStoreBusinessAmStartHours() {
        return storeBusinessAmStartHours;
    }

    public void setStoreBusinessAmStartHours(String storeBusinessAmStartHours) {
        this.storeBusinessAmStartHours = storeBusinessAmStartHours;
    }

    public String getStoreBusinessAmEndHours() {
        return storeBusinessAmEndHours;
    }

    public void setStoreBusinessAmEndHours(String storeBusinessAmEndHours) {
        this.storeBusinessAmEndHours = storeBusinessAmEndHours;
    }

    public String getStoreBusinessPmStartHours() {
        return storeBusinessPmStartHours;
    }

    public void setStoreBusinessPmStartHours(String storeBusinessPmStartHours) {
        this.storeBusinessPmStartHours = storeBusinessPmStartHours;
    }

    public String getStoreBusinessPmEndHours() {
        return storeBusinessPmEndHours;
    }

    public void setStoreBusinessPmEndHours(String storeBusinessPmEndHours) {
        this.storeBusinessPmEndHours = storeBusinessPmEndHours;
    }

    public String getStoreBusinessDay() {
        return storeBusinessDay;
    }

    public void setStoreBusinessDay(String storeBusinessDay) {
        this.storeBusinessDay = storeBusinessDay;
    }

    public StoreInfo() {
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storePhone=" + storePhone +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeAdmin='" + storeAdmin + '\'' +
                ", storeDescription='" + storeDescription + '\'' +
                ", storeStatus=" + storeStatus +
                ", storeLogo='" + storeLogo + '\'' +
                ", storeNotice='" + storeNotice + '\'' +
                ", storeType=" + storeType +
                ", seatCost=" + seatCost +
                ", serviceCost='" + serviceCost + '\'' +
                ", storeBusinessAmStartHours='" + storeBusinessAmStartHours + '\'' +
                ", storeBusinessAmEndHours='" + storeBusinessAmEndHours + '\'' +
                ", storeBusinessPmStartHours='" + storeBusinessPmStartHours + '\'' +
                ", storeBusinessPmEndHours='" + storeBusinessPmEndHours + '\'' +
                ", storeBusinessDay='" + storeBusinessDay + '\'' +
                ", storeImg=" + Arrays.toString(storeImg) +
                ", userId=" + userId +
                '}';
    }
}
