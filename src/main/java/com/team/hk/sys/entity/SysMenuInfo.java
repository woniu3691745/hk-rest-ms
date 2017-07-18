package com.team.hk.sys.entity;

import com.team.hk.common.CommonEntity;

import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统菜单实体
 */
public class SysMenuInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String path;
    private String component;
    private String redirect;
    private String name;
    private String icon;
    private Long parent;
    private String role;
    private int type;

    private List<MenuFormatInfo> children;

    public List<MenuFormatInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuFormatInfo> children) {
        this.children = children;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SysMenuInfo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", redirect='" + redirect + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", parent=" + parent +
                ", role='" + role + '\'' +
                ", type=" + type +
                ", children=" + children +
                '}';
    }

    public SysMenuInfo() {
    }
}
