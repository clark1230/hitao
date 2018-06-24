package com.hzitxx.hitao.entity;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 平台后台角色
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
public class ShopRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDescription;

    private Date createdTime;
    /**
     * 创建人
     */
    private Integer createdBy;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 修改人
     */
    private Integer updatedBy;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
 
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
 
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
 
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
 
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
 
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
 
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
 


    @Override
    public String toString() {
        return "ShopRole{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", roleDescription=" + roleDescription +
        ", createdTime=" + createdTime +
        ", createdBy=" + createdBy +
        ", updatedTime=" + updatedTime +
        ", updatedBy=" + updatedBy +
        "}";
    }
}