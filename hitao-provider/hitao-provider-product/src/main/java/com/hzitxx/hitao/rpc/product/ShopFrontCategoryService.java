package com.hzitxx.hitao.rpc.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopFrontCategory;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-13
 */

public interface ShopFrontCategoryService {

    int addShopFrontCategory(ShopFrontCategory shopFrontCategory);

    int addShopFrontCategorySelective(ShopFrontCategory obj);

    int deleteById(int frontCatId);

    int deleteByIds(String[] ids);

    int updateById(ShopFrontCategory shopFrontCategory);

    int updateSelectiveById(ShopFrontCategory shopFrontCategory);

    ServerResponse searchShopFrontCategory(Map<String, Object> map);

    ServerResponse currentCategory(Integer parentId);

    /**
     * 根据编号查询数据
     *
     */
    ShopFrontCategory findOne(Integer frontCatId);

}
