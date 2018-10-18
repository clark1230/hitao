package com.hzitxx.hitao.mapper.market;


import com.hzitxx.hitao.system.pojo.market.ShopArticleClass;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
public interface ShopArticleClassMapper{

    int addShopArticleClass(ShopArticleClass obj);

    int addShopArticleClassSelective(ShopArticleClass obj);

    int deleteById(int acId);
                                    
    int deleteByIds(String[] ids);

    int updateById(ShopArticleClass shopArticleClass);

    int updateSelectiveById(ShopArticleClass shopArticleClass);

    ShopArticleClass findOne(Integer acId);
                                    
    List<ShopArticleClass> searchShopArticleClass(Map<String, Object> map);
}