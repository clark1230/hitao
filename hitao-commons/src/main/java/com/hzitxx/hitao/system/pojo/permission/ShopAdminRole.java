package com.hzitxx.hitao.system.pojo.permission;

import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
public class ShopAdminRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 管理员编号
     */
    private Integer adminId;
    /**
     * 权限编号
     */
    private Integer roleId;

    public ShopAdminRole() {
    }

    public ShopAdminRole(Integer adminId, Integer roleId) {
        this.adminId = adminId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
 
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
 


    @Override
    public String toString() {
        return "ShopAdminRole{" +
        "id=" + id +
        ", adminId=" + adminId +
        ", roleId=" + roleId +
        "}";
    }
}