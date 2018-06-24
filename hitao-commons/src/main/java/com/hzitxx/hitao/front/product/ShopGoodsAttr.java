package com.hzitxx.hitao.front.product;

import com.fasterxml.jackson.annotation.JsonInclude;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品属性表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-19
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopGoodsAttr implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品分类id
     */
    private Integer catId;
    /**
     * 属性id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer attrId;
    /**
     * 属性值
     */
    private String attrValue;
    /**
     * 是否删除,0:未删除 1:删除
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer isDel;
    /**
     * 录入时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdTime;
    /**
     * 修改时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedTiime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
 
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }
 
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
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
 
    public Date getUpdatedTiime() {
        return updatedTiime;
    }

    public void setUpdatedTiime(Date updatedTiime) {
        this.updatedTiime = updatedTiime;
    }
 


    @Override
    public String toString() {
        return "ShopGoodsAttr{" +
        "goodsId=" + goodsId +
        ", catId=" + catId +
        ", attrId=" + attrId +
        ", attrValue=" + attrValue +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTiime=" + updatedTiime +
        "}";
    }
}