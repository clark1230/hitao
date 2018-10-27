package com.hzitxx.hitao.service.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrTemplate;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性模板表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */

public interface IShopGoodsAttrTemplateService  {
    ServerResponse addShopGoodsAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate);

    ServerResponse addShopGoodsAttrTemplateSelective(ShopGoodsAttrTemplate obj);

    ServerResponse deleteById(int attrId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopGoodsAttrTemplate shopGoodsAttrTemplate);

    ServerResponse updateSelectiveById(ShopGoodsAttrTemplate shopGoodsAttrTemplate);

    ServerResponse<List<ShopGoodsAttrTemplate>> searchShopGoodsAttrTemplate(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
   // ServerResponse<LayuiEntity<ShopGoodsAttrTemplate>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ShopGoodsAttrTemplate> findOne(Integer attrId);



    ServerResponse findByCatId(Integer catId);

}
