package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性模板表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
public interface ShopGoodsAttrTemplateMapper{

    int addShopGoodsAttrTemplate(ShopGoodsAttrTemplate obj);

    int addShopGoodsAttrTemplateSelective(ShopGoodsAttrTemplate obj);

    int deleteById(int attrId);
                        
    int deleteByIds(String[] ids);

    int updateById(ShopGoodsAttrTemplate shopGoodsAttrTemplate);

    int updateSelectiveById(ShopGoodsAttrTemplate shopGoodsAttrTemplate);

    ShopGoodsAttrTemplate findOne(Integer attrId);
                        
    List<ShopGoodsAttrTemplate> searchShopGoodsAttrTemplate(@Param("map") Map<String, Object> map);

    int updateSelectiveByCatId(ShopGoodsAttrTemplate shopGoodsAttrTemplate);

    ShopGoodsAttrTemplate findByCatId(Integer catId);
}