package com.hzitxx.hitao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShopGoodsCart {
    /**
     * 商品编号
     */
    private int goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品广告词
     */
    private String goodsJingle;
    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;
    /**
     * 商品数量
     */
    private int number;
    /**
     * 商品主图
     */
    private String mainImage;
    /**
     * 总价
     */
    private BigDecimal totalFee;

    @Override
    public String toString() {
        return "ShopGoodsCart{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsJingle='" + goodsJingle + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", number=" + number +
                ", mainImage='" + mainImage + '\'' +
                ", totalFee=" + totalFee +
                '}';
    }
}
