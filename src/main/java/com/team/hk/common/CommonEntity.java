package com.team.hk.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lidongliang on 2017/6/28.
 * 抽象父类Entity
 */
public abstract class CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String creater;         // 创建者
    private Date createDateTime;    // 创建时间
    private String modify;          // 修改者
    private Date updateDateTime;    // 修改时间
    private int status = 0;         // 状态

    private Long pageNo;  // 开始页
    private Long pageSize;   // 每页数量

    public CommonEntity() {
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

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CommonEntity{" +
                "creater='" + creater + '\'' +
                ", createDateTime=" + createDateTime +
                ", modify='" + modify + '\'' +
                ", updateDateTime=" + updateDateTime +
                ", status=" + status +
                '}';
    }

}
