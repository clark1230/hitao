package com.hzitxx.hitao.entity;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-15
 */
public class ShopAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员ID
     */
    private Integer adminId;
    /**
     * 管理员名称
     */
    private String adminName;
    /**
     * 管理员密码
     */
    private String adminPassword;
    /**
     * 登录次数
     */
    private Integer adminLoginNum;
    /**
     * 是否超级管理员
     */
    private Integer adminIsSuper;
    /**
     * 权限组ID
     */
    private Integer adminGid;
    /**
     * 删除状态
     */
    private Integer isDel;
    /**
     * 登录时间
     */
    private Date adminLoginTime;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
 
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
 
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
 
    public Integer getAdminLoginNum() {
        return adminLoginNum;
    }

    public void setAdminLoginNum(Integer adminLoginNum) {
        this.adminLoginNum = adminLoginNum;
    }
 
    public Integer getAdminIsSuper() {
        return adminIsSuper;
    }

    public void setAdminIsSuper(Integer adminIsSuper) {
        this.adminIsSuper = adminIsSuper;
    }
 
    public Integer getAdminGid() {
        return adminGid;
    }

    public void setAdminGid(Integer adminGid) {
        this.adminGid = adminGid;
    }
 
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
 
    public Date getAdminLoginTime() {
        return adminLoginTime;
    }

    public void setAdminLoginTime(Date adminLoginTime) {
        this.adminLoginTime = adminLoginTime;
    }
 
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
 
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
 


    @Override
    public String toString() {
        return "ShopAdmin{" +
        "adminId=" + adminId +
        ", adminName=" + adminName +
        ", adminPassword=" + adminPassword +
        ", adminLoginNum=" + adminLoginNum +
        ", adminIsSuper=" + adminIsSuper +
        ", adminGid=" + adminGid +
        ", isDel=" + isDel +
        ", adminLoginTime=" + adminLoginTime +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}