package com.hzitxx.hitao.rpc.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.product.ShopGoods;

public interface ShopGoodsService {

    ServerResponse findGoods();

    ServerResponse findOne(int goodsId,Integer memberId);

    ServerResponse<ShopGoods> findById(Integer goodsId);
    /**
     * 库存的检查
     * @param goodsId
     * @return
     */
    ServerResponse checkout(int goodsId,int number);
}
