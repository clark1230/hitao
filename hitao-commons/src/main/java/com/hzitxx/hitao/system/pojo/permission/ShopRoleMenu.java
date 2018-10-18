package com.hzitxx.hitao.system.pojo.permission;

import java.io.Serializable;
/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
public class ShopRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private Integer id;
    private Integer roleId;
    private Integer menuId;

    public ShopRoleMenu() {
    }

    public ShopRoleMenu(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
 
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "ShopRoleMenu{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }
}