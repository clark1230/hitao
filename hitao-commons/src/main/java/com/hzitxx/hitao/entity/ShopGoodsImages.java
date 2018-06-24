package com.hzitxx.hitao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 商品图片
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-05
 */
@Data
public class ShopGoodsImages implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品图片id
     */
    private Integer goodsImageId;

    /**
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 颜色规格值id
     */
    private Integer colorId;
    /**
     * 商品图片
     */
    private String goodsImage;
    /**
     * 排序
     */
    private Integer goodsImageSort;
    /**
     * 默认主题，1是，0否
     */
    private Integer isDefault;


    @Override
    public String toString() {
        return "ShopGoodsImages{" +
        "goodsImageId=" + goodsImageId +
        ", colorId=" + colorId +
        ", goodsImage=" + goodsImage +
        ", goodsImageSort=" + goodsImageSort +
        ", isDefault=" + isDefault +
        "}";
    }
}