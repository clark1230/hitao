package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-14
 */
public interface ShopGoodsAttrMapper{

    int addShopGoodsAttr(ShopGoodsAttr obj);

    int addShopGoodsAttrSelective(ShopGoodsAttr obj);

    int deleteById(int goodsId);
                            
    int deleteByIds(String[] ids);

    int updateById(ShopGoodsAttr shopGoodsAttr);

    int updateSelectiveById(ShopGoodsAttr shopGoodsAttr);

    ShopGoodsAttr findOne(Integer goodsId);
                            
    List<ShopGoodsAttr> searchShopGoodsAttr(@Param("map") Map<String, Object> map);
}