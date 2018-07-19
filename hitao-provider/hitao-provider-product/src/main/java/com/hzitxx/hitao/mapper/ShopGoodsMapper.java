package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.front.product.ShopGoods;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-18
 */
public interface ShopGoodsMapper{
    /**
     * 查询商品信息
     * @return
     */
    List<ShopGoods> findGoods();

    /**
     * 根据id查询数据
     * @param goodsId
     * @return
     */
    ShopGoods findOne(int goodsId);

    /**
     * 库存检查
     * @param goodsId
     * @return
     */
    int checkout(int goodsId);

    /**
     * 查询所有非逻辑删除商品数量
     * @return
     */
    int goodsCount();
}