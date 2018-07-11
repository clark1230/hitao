package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性组 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
public interface ShopGoodsAttrGroupMapper{

    int addShopGoodsAttrGroup(ShopGoodsAttrGroup obj);

    int addShopGoodsAttrGroupSelective(ShopGoodsAttrGroup obj);

    int deleteById(int groupId);
                    
    int deleteByIds(String[] ids);

    int updateById(ShopGoodsAttrGroup shopGoodsAttrGroup);

    int updateSelectiveById(ShopGoodsAttrGroup shopGoodsAttrGroup);

    ShopGoodsAttrGroup findOne(Integer groupId);
                    
    List<ShopGoodsAttrGroup> searchShopGoodsAttrGroup(@Param("map") Map<String, Object> map);
}