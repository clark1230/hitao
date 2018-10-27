package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import com.hzitxx.hitao.utils.LayuiEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家收藏表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-08
 */

public interface IShopFavoritesService  {

    ServerResponse addShopFavorites(ShopFavorites shopFavorites);

    ServerResponse addOrDelete(ShopFavorites obj,Integer type);

    ServerResponse deleteById(int favId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopFavorites shopFavorites);

    ServerResponse updateSelectiveById(ShopFavorites shopFavorites);

    ServerResponse<List<ShopFavorites>> searchShopFavorites(Map<String, Object> map);



    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ShopFavorites> findOne(Integer favId);

    /**
     * 检查商品是否被收藏了
     * @param memberId
     * @param goodsId
     * @return
     */
    ServerResponse<ShopFavorites> checkFavorites(Integer memberId,Integer goodsId);

    /**
     * 获取分页数据
     * @param page 页数
     * @param limit  条数
     * @param map  查询条件
     * @return
     */
    ServerResponse<LayuiEntity<ShopFavorites>> page(Integer page, Integer limit,Map<String,Object> map);
}
