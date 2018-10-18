package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.ShopDic;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-13
 */

public interface IShopDicService  {
    ServerResponse addShopDic(ShopDic shopDic);

    ServerResponse addShopDicSelective(ShopDic obj);



    ServerResponse updateById(ShopDic shopDic);

    ServerResponse updateSelectiveById(ShopDic shopDic);

    ServerResponse<List<ShopDic>> searchShopDic(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopDic>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *@param dicId
     */
    ServerResponse<ShopDic> findOne(Integer dicId);
}
