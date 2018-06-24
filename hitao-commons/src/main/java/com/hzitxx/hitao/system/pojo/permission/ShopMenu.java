package com.hzitxx.hitao.system.pojo.permission;

import lombok.Data;

import  java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-20
 */
@Data
public class ShopMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * url路径
     */
    private String url;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 菜单等级
     */
    private Integer level;
    /**
     * 菜单ID路径
     */
    private String path;
    /**
     * 描述
     */
    private String description;
    /**
     * 录入人
     */
    private Integer createdBy;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private Integer updatedBy;
    /**
     * 修改时间
     */
    private Date updatedTime;

    private List<ShopMenu> children = new ArrayList<>();

    @Override
    public String toString() {
        return "ShopMenu{" +
        "id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", level=" + level +
        ", path=" + path +
        ", description=" + description +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        "}";
    }
}