package com.hzitxx.hitao.service.market;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.market.ShopArticleClass;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类表 服务类
 * </p>
 * @author xianyaoji
 * @since 2018-08-08
 */

public interface IShopArticleClassService  {
    ServerResponse addShopArticleClass(ShopArticleClass shopArticleClass);

    ServerResponse addShopArticleClassSelective(ShopArticleClass obj);

    ServerResponse deleteById(int acId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopArticleClass shopArticleClass);

    ServerResponse updateSelectiveById(ShopArticleClass shopArticleClass);

    ServerResponse<List<ShopArticleClass>> searchShopArticleClass(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopArticleClass>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ShopArticleClass> findOne(Integer acId);

}
