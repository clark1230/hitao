package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopGoodsCart;

public interface ShopCartService {
    /**
     * 添加到购物车中
     * @param shopGoodsCart
     * @return
     */
    ServerResponse addCart(int memberId,ShopGoodsCart shopGoodsCart);

    /**
     * 删除购物车信息
     * @param memberId
     * @param goodsIds
     * @return
     */
    ServerResponse deleteCart(int memberId,Long[] goodsIds);

    /**
     * 获取购物车信息
     * @param memberId
     * @return
     */
    ServerResponse cartList(int memberId);

    /**
     * 获取会员的购物车商品数量
     * @param memberId
     * @return
     */
    ServerResponse cartCount(int memberId);

    /**
     * 编辑购物车信息
     * @param memberId
     * @param shopGoodsCart
     * @return
     */
    ServerResponse update(int memberId,ShopGoodsCart shopGoodsCart);
}
