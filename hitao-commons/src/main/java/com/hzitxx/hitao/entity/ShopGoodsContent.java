package com.hzitxx.hitao.entity;

import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品内容表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-09
 */
@Data
public class ShopGoodsContent implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品编号，主键值来自商品表
     */
    private Integer goodsId;
    /**
     * 商品内容
     */
    private String content;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;


    @Override
    public String toString() {
        return "ShopGoodsContent{" +
        "goodsId=" + goodsId +
        ", content=" + content +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}