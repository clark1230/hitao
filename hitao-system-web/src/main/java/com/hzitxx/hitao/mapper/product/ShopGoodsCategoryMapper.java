package com.hzitxx.hitao.mapper.product;

import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-05
 */
public interface ShopGoodsCategoryMapper {

    int addShopGoodsCategory(ShopGoodsCategory obj);

    int addShopGoodsCategorySelective(ShopGoodsCategory obj);

    int deleteById(int gcId);

    int deleteByIds(String[] ids);

    int updateById(ShopGoodsCategory shopGoodsCategory);

    int updateSelectiveById(ShopGoodsCategory shopGoodsCategory);

    ShopGoodsCategory findOne(Integer gcId);

    List<ShopGoodsCategory> searchShopGoodsCategory(@Param("map") Map<String, Object> map);


    List<ShopGoodsCategory> findByPId(int parentId);
}