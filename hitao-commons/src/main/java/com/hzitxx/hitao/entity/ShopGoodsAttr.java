package com.hzitxx.hitao.entity;

import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品属性表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-11
 */
@Data
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
    private Integer attrId;
    /**
     * 属性值
     */
    private String attrValue;
    /**
     * 是否删除,0:删除 1:删除
     */
    private Integer isDel;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTiime;

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