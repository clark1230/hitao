package com.hzitxx.hitao.system.pojo.product;

import lombok.Data;

import  java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-02
 */
@Data
public class ShopGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品id(SKU)
     */
    private Integer goodsId;
    /**
     * 商品名称（+规格名称）
     */
    private String goodsName;
    /**
     * 商品广告词
     */
    private String goodsJingle;
    /**
     * 商品分类id
     */
    private Integer gcId;
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;
    /**
     * 市场价
     */
    private BigDecimal goodsMarketprice;
    /**
     * 商家编号
     */
    private String goodsSerial;
    /**
     * 商品点击数量
     */
    private Integer goodsClick;
    /**
     * 销售数量
     */
    private Integer goodsSalenum;
    /**
     * 收藏数量
     */
    private Integer goodsCollect;
    /**
     * 商品规格序列化
     */
    private String goodsSpec;
    /**
     * 商品库存
     */
    private Integer goodsStorage;
    /**
     * 商品主图
     */
    private String mainImage;
    /**
     * 商品状态 0下架，1正常，10违规（禁售）
     */
    private Integer goodsState;
    /**
     * 商品审核 1通过，0未通过，10审核中
     */
    private Integer goodsVerify;
    /**
     * 一级地区id
     */
    private Integer areaid1;
    /**
     * 二级地区id
     */
    private Integer areaid2;
    /**
     * 颜色规格id
     */
    private Integer colorId;
    /**
     * 运费模板id
     */
    private Integer transportId;
    /**
     * 运费 0为免运费
     */
    private BigDecimal goodsFreight;
    /**
     * 是否开具增值税发票 1是，0否
     */
    private Integer goodsVat;
    /**
     * 商品推荐 1是，0否 默认0
     */
    private Integer goodsCommend;
    /**
     * 好评星级
     */
    private Integer evaluationGoodStar;
    /**
     * 评价数
     */
    private Integer evaluationCount;
    /**
     * 是否删除0:未删除;1:已删除，默认为0
     */
    private Integer isDel;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;


    @Override
    public String toString() {
        return "ShopGoods{" +
        "goodsId=" + goodsId +
        ", goodsName=" + goodsName +
        ", goodsJingle=" + goodsJingle +
        ", gcId=" + gcId +
        ", brandId=" + brandId +
        ", goodsPrice=" + goodsPrice +
        ", goodsMarketprice=" + goodsMarketprice +
        ", goodsSerial=" + goodsSerial +
        ", goodsClick=" + goodsClick +
        ", goodsSalenum=" + goodsSalenum +
        ", goodsCollect=" + goodsCollect +
        ", goodsSpec=" + goodsSpec +
        ", goodsStorage=" + goodsStorage +
        ", mainImage=" + mainImage +
        ", goodsState=" + goodsState +
        ", goodsVerify=" + goodsVerify +
        ", areaid1=" + areaid1 +
        ", areaid2=" + areaid2 +
        ", colorId=" + colorId +
        ", transportId=" + transportId +
        ", goodsFreight=" + goodsFreight +
        ", goodsVat=" + goodsVat +
        ", goodsCommend=" + goodsCommend +
        ", evaluationGoodStar=" + evaluationGoodStar +
        ", evaluationCount=" + evaluationCount +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}