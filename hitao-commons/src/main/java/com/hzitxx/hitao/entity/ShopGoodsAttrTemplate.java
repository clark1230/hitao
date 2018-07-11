package com.hzitxx.hitao.entity;

import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品属性模板表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-10
 */
@Data
public class ShopGoodsAttrTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性id
     */
    private Integer attrId;
    /**
     * 所属类型id
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