package com.hzitxx.hitao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品类型与品牌对应表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-05
 */
@Data
public class ShopTypeBrand implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 类型id
     */
    private Integer typeId;
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 是否删除0：未删除1：已删除,默认为0
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;



    @Override
    public String toString() {
        return "ShopTypeBrand{" +
        "typeId=" + typeId +
        ", brandId=" + brandId +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}