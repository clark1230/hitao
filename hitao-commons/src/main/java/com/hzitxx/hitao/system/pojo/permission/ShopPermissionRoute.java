package com.hzitxx.hitao.system.pojo.permission;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import  java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-21
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopPermissionRoute implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 路由编号
     */
    @JsonIgnore
    private Integer routeId;
    /**
     * 父级编号
     */
    @JsonIgnore
    private Integer parentId;
    /**
     * 路径
     */
    private String path;
    /**
     * 组件
     */
    private String component;
    /**
     * 命名路由
     */
    private String name;
    /**
     * 重定向
     */
    @JsonIgnore
    private String redirect;
    /**
     * 元数据
     */
    private String meta;

    /**
     * 子权限
     */
    private List<ShopPermissionRoute> children;


    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
 
    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public List<ShopPermissionRoute> getChildren() {
        return children;
    }

    public void setChildren(List<ShopPermissionRoute> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ShopPermissionRoute{" +
        "routeId=" + routeId +
        ",parentId=" + parentId +
        ", path=" + path +
        ", component=" + component +
        ", name=" + name +
        ", redirect=" + redirect +
        ", meta=" + meta +
        "}";
    }
}