package com.hzitxx.hitao.vo.shopgoods;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopGoodsVO {
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
     * 商品属性值
     */
    private List<ShopGoodsCateVO> attrValue;

    /**
     *商品内容
     */
    private String content;

    @Override
    public String toString() {
        return "ShopGoodsVO{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsJingle='" + goodsJingle + '\'' +
                ", gcId=" + gcId +
                ", brandId=" + brandId +
                ", goodsPrice=" + goodsPrice +
                ", goodsMarketprice=" + goodsMarketprice +
                ", goodsSerial='" + goodsSerial + '\'' +
                ", goodsSpec='" + goodsSpec + '\'' +
                ", goodsStorage=" + goodsStorage +
                ", mainImage='" + mainImage + '\'' +
                ", transportId=" + transportId +
                ", goodsFreight=" + goodsFreight +
                ", goodsVat=" + goodsVat +
                ", goodsCommend=" + goodsCommend +
                ", attrValue='" + attrValue + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
