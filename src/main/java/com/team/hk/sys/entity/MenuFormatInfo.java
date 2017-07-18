package com.team.hk.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 返回vue-router菜单格式
 */
public class MenuFormatInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String path;
    private String component;
    private String redirect;
    private String name;
    private String icon;
    private Long parent;
    private String[] role;

    private List<MenuFormatInfo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public List<MenuFormatInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuFormatInfo> children) {
        this.children = children;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public MenuFormatInfo() {
    }
}
