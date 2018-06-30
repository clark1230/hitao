package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.front.product.ShopGoodsAttr;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-19
 */
public interface ShopGoodsAttrMapper{

    ShopGoodsAttr findOne(Integer goodsId);
                            
    List<ShopGoodsAttr> searchShopGoodsAttr(@Param("map") Map<String, Object> map);
}