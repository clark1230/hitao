package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.front.product.ShopGoodsContent;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品内容表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-19
 */
public interface ShopGoodsContentMapper{

    ShopGoodsContent findOne(Integer goodsId);
                
    List<ShopGoodsContent> searchShopGoodsContent(@Param("map") Map<String, Object> map);
}