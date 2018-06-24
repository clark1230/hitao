package com.hzitxx.hitao.rpc.product.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.product.ShopGoodsService;
import org.springframework.stereotype.Service;

@Service
public class ShopGoodsHystrix implements ShopGoodsService {
    @Override
    public Object findGoods() {
        return ServerResponse.createByErrorMessage("商品服务调用失败!");
    }

    @Override
    public Object details(int goodsId,Integer memberId) {
       return ServerResponse.createByErrorMessage("商品服务调用失败!");
    }
}
