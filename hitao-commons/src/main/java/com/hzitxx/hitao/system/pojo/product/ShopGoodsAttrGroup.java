package com.hzitxx.hitao.system.pojo.product;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 商品属性组
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
public class ShopGoodsAttrGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性组编号
     */
    private Integer groupId;
    /**
     * 属性组名称
     */
    private String groupName;
    /**
     * 是否删除 0 表示不逻辑删除 1:表示逻辑删除 默认为0
     */
    private Integer isDel;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
 
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
 
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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
        return "ShopGoodsAttrGroup{" +
        "groupId=" + groupId +
        ", groupName=" + groupName +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}