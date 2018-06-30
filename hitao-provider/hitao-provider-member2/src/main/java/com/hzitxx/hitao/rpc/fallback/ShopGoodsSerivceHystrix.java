package com.hzitxx.hitao.rpc.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.ShopGoodsService;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import org.springframework.stereotype.Component;

@Component
public class ShopGoodsSerivceHystrix implements ShopGoodsService {
    @Override
    public ServerResponse<ShopGoods> findById(Integer goodsId) {
        return ServerResponse.createByErrorMessage("调用商品微服务失败!");
    }
}
