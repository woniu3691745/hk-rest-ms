package com.team.hk.menuInfo.entity;

/**
 * Created by lidongliang on 2017/8/21.
 */
public class MenuInfoMobile {

    private String name;
    private String foods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoods() {
        return foods;
    }

    public void setFoods(String foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "MenuInfoMobile{" +
                "name='" + name + '\'' +
                ", foods='" + foods + '\'' +
                '}';
    }
}
