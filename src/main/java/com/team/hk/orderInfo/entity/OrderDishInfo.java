package com.team.hk.orderInfo.entity;

import com.team.hk.common.CommonEntity;

/**
 * Created by lidongliang on 2017/7/6.
 * 订单_菜肴信息实体
 */
public class OrderDishInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long orderId;                   // 订单ID
    private Long dishesId;                  // 菜肴ID
    private Long menuId;                    // 菜单ID
    private String dishesName;              // 菜肴名
    private Float dishesPrice;              // 菜肴价钱
    private String dishesDiscountPrice;     // 菜肴折扣
    private int amount;                    // 数量

    public OrderDishInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDishesId() {
        return dishesId;
    }

    public void setDishesId(Long dishesId) {
        this.dishesId = dishesId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public Float getDishesPrice() {
        return dishesPrice;
    }

    public void setDishesPrice(Float dishesPrice) {
        this.dishesPrice = dishesPrice;
    }

    public String getDishesDiscountPrice() {
        return dishesDiscountPrice;
    }

    public void setDishesDiscountPrice(String dishesDiscountPrice) {
        this.dishesDiscountPrice = dishesDiscountPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDishInfo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", dishesId=" + dishesId +
                ", menuId=" + menuId +
                ", dishesName='" + dishesName + '\'' +
                ", dishesPrice=" + dishesPrice +
                ", dishesDiscountPrice='" + dishesDiscountPrice + '\'' +
                ", amount=" + amount +
                '}';
    }
}
