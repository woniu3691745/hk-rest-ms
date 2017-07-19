package com.team.hk.sys.entity;

import com.team.hk.common.CommonEntity;

/**
 * Created by lidongliang on 2017/7/19.
 * 系统字典表实体
 */
public class SysDictInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long typeId;
    private String typeName;
    private String value;
    private String name;

    public SysDictInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysDictionaryInfo{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
