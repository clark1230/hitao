package com.hzitxx.hitao.front.product.vo;

import com.hzitxx.hitao.front.product.ShopGoods;
import com.hzitxx.hitao.front.product.ShopGoodsAttr;
import com.hzitxx.hitao.front.product.ShopGoodsContent;
import lombok.Data;

import java.util.List;

@Data
public class GoodsDetailVo {
    /**
     * 商品信息
     */
    private ShopGoods shopGoods;
    /**
     * 商品属性
     */
    private List<GroupAttrVo> goodsAttr;
    /**
     * 商品内容
     */
    private ShopGoodsContent  goodsContent;
    /**
     * 是否是收藏商品
     */
    private Integer  isFavorites;

}
