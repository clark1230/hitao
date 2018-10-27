package com.hzitxx.hitao.dao;

import com.hzitxx.hitao.entity.ShopGoodsCart;

import java.util.List;

public interface CartDao {
    /**
     * 添加商品到购物车中
     * @param  memberId
     * @param shopGoodsCart
     * @return
     */
    boolean addCart(int memberId,ShopGoodsCart shopGoodsCart);

    /**
     * 删除购物车信息
     * @param memberId
     * @param goodsIds
     * @return
     */
    boolean deleteCart(int memberId,Long[] goodsIds);

    /**
     * 获取购物车信息
     * @return
     */
    List<ShopGoodsCart> cartList(int memberId);

    /**
     * 编辑购物车信息
     * @param memberId
     * @param shopGoodsCart
     * @return
     */
    boolean update(int memberId,ShopGoodsCart shopGoodsCart);

    /**
     * 获取会员的购物车商品数量
     * @param memberId
     * @return
     */
    long cartCount(int memberId);

}
