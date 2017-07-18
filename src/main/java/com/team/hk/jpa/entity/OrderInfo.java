package com.team.hk.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lidongliang on 2017/6/29.
 * JPA 实体类
 */
@Entity
@Table(name = "hk_order_info_t")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long orderId;               // 订单编号
    @Column(nullable = true)
    private Long storeId;               // 餐厅编号
    @Column(nullable = true)
    private Long tableId;               // 桌位编号
    @Column(nullable = true)
    private int orderStatus;            // 订单状态
    @Column(nullable = true)
    private Date startDateTime;         // 下单时间
    @Column(nullable = true)
    private float orderAmount;          // 消费金额
    @Column(nullable = true)
    private String orderCreater;        // 订单创建者
    @Column(nullable = true)
    private int MEMBER;                 // 用餐人数
    private String comment;             // 备注
    @Column(nullable = true)
    private String creater;             // 创建者
    @Column(nullable = true)
    private Date createDateTime;        // 创建时间
    @Column(nullable = true)
    private String modify;              // 修改者
    @Column(nullable = true)
    private Date updateDateTime;        // 修改时间
    @Column(nullable = true)
    private int status = 0;             // 状态

    public Long getOrderId() {
        return orderId;
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

    public int getMEMBER() {
        return MEMBER;
    }

    public void setMEMBER(int MEMBER) {
        this.MEMBER = MEMBER;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderInfoController{" +
                "orderId=" + orderId +
                ", storeId=" + storeId +
                ", tableId=" + tableId +
                ", orderStatus=" + orderStatus +
                ", startDateTime=" + startDateTime +
                ", orderAmount=" + orderAmount +
                ", orderCreater='" + orderCreater + '\'' +
                ", MEMBER=" + MEMBER +
                ", comment='" + comment + '\'' +
                ", creater='" + creater + '\'' +
                ", createDateTime=" + createDateTime +
                ", modify='" + modify + '\'' +
                ", updateDateTime=" + updateDateTime +
                ", status=" + status +
                '}';
    }
}
