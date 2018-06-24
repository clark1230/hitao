package com.hzitxx.hitao.front.product;

import com.fasterxml.jackson.annotation.JsonInclude;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品内容表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-19
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdTime;
    /**
     * 修改时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
 
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "ShopGoodsContent{" +
        "goodsId=" + goodsId +
        ", content=" + content +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}