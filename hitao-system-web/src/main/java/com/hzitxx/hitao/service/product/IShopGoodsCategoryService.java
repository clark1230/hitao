package com.hzitxx.hitao.service.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.Map;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-03
 */

public interface IShopGoodsCategoryService  {

    ServerResponse addShopGoodsCategory(ShopGoodsCategory shopGoodsCategory);

    ServerResponse addShopGoodsCategorySelective(ShopGoodsCategory obj);

    ServerResponse deleteById(int catId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopGoodsCategory shopGoodsCategory);

    ServerResponse updateSelectiveById(ShopGoodsCategory shopGoodsCategory);

    ServerResponse searchShopGoodsCategory(Map<String, Object> map);

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
    ServerResponse findOne(Integer catId);

    /**
     * 获取类目
     * @return
     */
    ServerResponse ajaxCate();


    /**
     * 根据父级编号查询类目信息
     * @param parentId
     * @return
     */
    ServerResponse findByPId(Integer parentId);

}
