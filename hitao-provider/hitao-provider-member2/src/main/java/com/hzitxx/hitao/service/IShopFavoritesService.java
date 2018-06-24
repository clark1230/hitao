package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;

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

}
