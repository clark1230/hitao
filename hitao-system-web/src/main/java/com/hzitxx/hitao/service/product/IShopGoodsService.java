package com.hzitxx.hitao.service.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.vo.shopgoods.ShopGoodsVO;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.Map;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-02
 */

public interface IShopGoodsService  {

    ServerResponse addShopGoods(ShopGoods shopGoods);

    ServerResponse addShopGoodsSelective(ShopGoodsVO shopGoodsVO);

    ServerResponse deleteById(int goodsId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopGoods shopGoods);

    ServerResponse updateSelectiveById(ShopGoodsVO shopGoodsVO);

    ServerResponse searchShopGoods(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopGoods>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer goodsId);

    /**
     * 商品上架或者下架
     * @param shopGoods
     * @return
     */
    ServerResponse onSalceOrShelves(ShopGoods shopGoods);

}
