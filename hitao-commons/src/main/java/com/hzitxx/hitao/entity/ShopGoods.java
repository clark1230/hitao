package com.hzitxx.hitao.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import  java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-18
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
 
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
 
    public String getGoodsJingle() {
        return goodsJingle;
    }

    public void setGoodsJingle(String goodsJingle) {
        this.goodsJingle = goodsJingle;
    }
 
    public Integer getGcId() {
        return gcId;
    }

    public void setGcId(Integer gcId) {
        this.gcId = gcId;
    }
 
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
 
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
 
    public BigDecimal getGoodsMarketprice() {
        return goodsMarketprice;
    }

    public void setGoodsMarketprice(BigDecimal goodsMarketprice) {
        this.goodsMarketprice = goodsMarketprice;
    }
 
    public String getGoodsSerial() {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial) {
        this.goodsSerial = goodsSerial;
    }
 
    public Integer getGoodsClick() {
        return goodsClick;
    }

    public void setGoodsClick(Integer goodsClick) {
        this.goodsClick = goodsClick;
    }
 
    public Integer getGoodsSalenum() {
        return goodsSalenum;
    }

    public void setGoodsSalenum(Integer goodsSalenum) {
        this.goodsSalenum = goodsSalenum;
    }
 
    public Integer getGoodsCollect() {
        return goodsCollect;
    }

    public void setGoodsCollect(Integer goodsCollect) {
        this.goodsCollect = goodsCollect;
    }
 
    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }
 
    public Integer getGoodsStorage() {
        return goodsStorage;
    }

    public void setGoodsStorage(Integer goodsStorage) {
        this.goodsStorage = goodsStorage;
    }
 
    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
 
    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }
 
    public Integer getGoodsVerify() {
        return goodsVerify;
    }

    public void setGoodsVerify(Integer goodsVerify) {
        this.goodsVerify = goodsVerify;
    }
 
    public Integer getAreaid1() {
        return areaid1;
    }

    public void setAreaid1(Integer areaid1) {
        this.areaid1 = areaid1;
    }
 
    public Integer getAreaid2() {
        return areaid2;
    }

    public void setAreaid2(Integer areaid2) {
        this.areaid2 = areaid2;
    }
 
    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
 
    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }
 
    public BigDecimal getGoodsFreight() {
        return goodsFreight;
    }

    public void setGoodsFreight(BigDecimal goodsFreight) {
        this.goodsFreight = goodsFreight;
    }
 
    public Integer getGoodsVat() {
        return goodsVat;
    }

    public void setGoodsVat(Integer goodsVat) {
        this.goodsVat = goodsVat;
    }
 
    public Integer getGoodsCommend() {
        return goodsCommend;
    }

    public void setGoodsCommend(Integer goodsCommend) {
        this.goodsCommend = goodsCommend;
    }
 
    public Integer getEvaluationGoodStar() {
        return evaluationGoodStar;
    }

    public void setEvaluationGoodStar(Integer evaluationGoodStar) {
        this.evaluationGoodStar = evaluationGoodStar;
    }
 
    public Integer getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(Integer evaluationCount) {
        this.evaluationCount = evaluationCount;
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