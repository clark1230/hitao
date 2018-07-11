package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;

import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.utils.LayuiEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-05
 */

public interface ShopGoodsCategoryService  {
    ServerResponse addShopGoodsCategory(ShopGoodsCategory shopGoodsCategory);

    ServerResponse addShopGoodsCategorySelective(ShopGoodsCategory obj);

    ServerResponse deleteById(int catId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopGoodsCategory shopGoodsCategory);

    ServerResponse updateSelectiveById(ShopGoodsCategory shopGoodsCategory);

    ServerResponse<List<ShopGoodsCategory>> searchShopGoodsCategory(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopGoodsCategory>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ShopGoodsCategory> findOne(Integer catId);

}
