package com.hzitxx.hitao.mapper.settings;


import com.hzitxx.hitao.system.pojo.ShopDic;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-13
 */
public interface ShopDicMapper{

    int addShopDic(ShopDic obj);

    int addShopDicSelective(ShopDic obj);

    ShopDic findOne(Integer dicId);

    int updateById(ShopDic shopDic);

    int updateSelectiveById(ShopDic shopDic);

    List<ShopDic> searchShopDic(Map<String, Object> map);
}