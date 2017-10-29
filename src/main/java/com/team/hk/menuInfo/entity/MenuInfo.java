package com.team.hk.menuInfo.entity;

import com.team.hk.common.CommonEntity;

/**
 * Created by lidongliang on 2017/7/7.
 * 菜单信息实体
 */
public class MenuInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long dishesId;              // 菜肴编号
    private Long menuId;                // 菜单编号
    private Long storeId;               // 餐厅编号
    private String dishesName;          // 菜肴名称
    private Double dishesPrice;         // 菜肴价钱
    private String dishesDiscountPrice; // 菜肴折扣
    private String dishesPriceNow;      // 菜肴当前价
    private String dishesDescription;   // 菜肴介绍
    private int dishesCategory;         // 菜系分类
    private String dishesImg;             // 菜肴图片
    private int dishesWaterStatus;      // 饮品
    private int isVegetarian;           // 素食
    private int stock;                  // 库存
    private int overplusStock;          // 剩余库存

    private String name;                // 字典表对应内容

    public MenuInfo() {
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "dishesId=" + dishesId +
                ", menuId=" + menuId +
                ", storeId=" + storeId +
                ", dishesName='" + dishesName + '\'' +
                ", dishesPrice=" + dishesPrice +
                ", dishesDiscountPrice='" + dishesDiscountPrice + '\'' +
                ", dishesPriceNow=" + dishesPriceNow +
                ", dishesDescription='" + dishesDescription + '\'' +
                ", dishesCategory=" + dishesCategory +
                ", dishesImg=" + dishesImg +
                ", dishesWaterStatus=" + dishesWaterStatus +
                ", isVegetarian=" + isVegetarian +
                ", stock=" + stock +
                ", overplusStock=" + overplusStock +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDishesId() {
        return dishesId;
    }

    public void setDishesId(Long dishesId) {
        this.dishesId = dishesId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public Double getDishesPrice() {
        return dishesPrice;
    }

    public void setDishesPrice(Double dishesPrice) {
        this.dishesPrice = dishesPrice;
    }

    public String getDishesDiscountPrice() {
        return dishesDiscountPrice;
    }

    public void setDishesDiscountPrice(String dishesDiscountPrice) {
        this.dishesDiscountPrice = dishesDiscountPrice;
    }

    public String getDishesDescription() {
        return dishesDescription;
    }

    public void setDishesDescription(String dishesDescription) {
        this.dishesDescription = dishesDescription;
    }

    public int getDishesCategory() {
        return dishesCategory;
    }

    public void setDishesCategory(int dishesCategory) {
        this.dishesCategory = dishesCategory;
    }

    public String getDishesImg() {
        return dishesImg;
    }

    public void setDishesImg(String dishesImg) {
        this.dishesImg = dishesImg;
    }

    public int getDishesWaterStatus() {
        return dishesWaterStatus;
    }

    public void setDishesWaterStatus(int dishesWaterStatus) {
        this.dishesWaterStatus = dishesWaterStatus;
    }

    public int getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(int isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getOverplusStock() {
        return overplusStock;
    }

    public void setOverplusStock(int overplusStock) {
        this.overplusStock = overplusStock;
    }

    public String getDishesPriceNow() {
        return dishesPriceNow;
    }

    public void setDishesPriceNow(String dishesPriceNow) {
        this.dishesPriceNow = dishesPriceNow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
