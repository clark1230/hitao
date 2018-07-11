package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrGroupTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性和属性组中间表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
public interface ShopGoodsAttrGroupTempMapper{

    int addShopGoodsAttrGroupTemp(ShopGoodsAttrGroupTemp obj);

    int addShopGoodsAttrGroupTempSelective(ShopGoodsAttrGroupTemp obj);

    int deleteById(int id);
            
    int deleteByIds(String[] ids);

    int updateById(ShopGoodsAttrGroupTemp shopGoodsAttrGroupTemp);

    int updateSelectiveById(ShopGoodsAttrGroupTemp shopGoodsAttrGroupTemp);

    ShopGoodsAttrGroupTemp findOne(Integer id);
            
    List<ShopGoodsAttrGroupTemp> searchShopGoodsAttrGroupTemp(@Param("map") Map<String, Object> map);
}