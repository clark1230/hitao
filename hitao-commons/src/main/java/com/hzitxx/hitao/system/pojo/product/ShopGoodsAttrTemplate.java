package com.hzitxx.hitao.system.pojo.product;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 商品属性模板表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
public class ShopGoodsAttrTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性id
     */
    private Integer attrId;
    /**
     * 所属类目编号
     */
    private Integer catId;
    /**
     * 属性值列
     */
    private String attrValue;
    /**
     * 是否删除0:未删除；1:已删除
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }
 
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }
 
    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
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
        return "ShopGoodsAttrTemplate{" +
        "attrId=" + attrId +
        ", catId=" + catId +
        ", attrValue=" + attrValue +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}