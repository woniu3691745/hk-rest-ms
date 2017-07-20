package com.team.hk.orderInfo.entity;

import com.team.hk.common.CommonEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by lidongliang on 2017/6/27.
 * 订单对订单_菜肴实体类
 */
public class OrderToDishInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long orderId;               // 订单编号
    private Long storeId;               // 餐厅编号
    private Long tableId;               // 桌位编号
    private int orderStatus;            // 订单状态
    private Date startDateTime;         // 下单时间
    private float orderAmount;          // 消费金额
    private String orderCreater;        // 订单创建者
    private int member;                 // 用餐人数
    private String comment;             // 备注

    private List<OrderDishInfo> OrderDishInfo;  // 订单_菜肴实体类

    public OrderToDishInfo() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderCreater() {
        return orderCreater;
    }

    public void setOrderCreater(String orderCreater) {
        this.orderCreater = orderCreater;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<com.team.hk.orderInfo.entity.OrderDishInfo> getOrderDishInfo() {
        return OrderDishInfo;
    }

    public void setOrderDishInfo(List<com.team.hk.orderInfo.entity.OrderDishInfo> orderDishInfo) {
        OrderDishInfo = orderDishInfo;
    }

    @Override
    public String toString() {
        return "OrderToDishInfo{" +
                "orderId=" + orderId +
                ", storeId=" + storeId +
                ", tableId=" + tableId +
                ", orderStatus=" + orderStatus +
                ", startDateTime=" + startDateTime +
                ", orderAmount=" + orderAmount +
                ", orderCreater='" + orderCreater + '\'' +
                ", member=" + member +
                ", comment='" + comment + '\'' +
                ", OrderDishInfo=" + OrderDishInfo +
                '}';
    }
}
