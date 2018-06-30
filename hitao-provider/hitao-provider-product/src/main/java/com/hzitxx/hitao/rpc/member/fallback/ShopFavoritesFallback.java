package com.hzitxx.hitao.rpc.member.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.member.ShopFavoritesService;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.springframework.stereotype.Component;

@Component
public class ShopFavoritesFallback implements ShopFavoritesService {

    @Override
    public ServerResponse<ShopFavorites> checkFavorites(Integer memberId, Integer goodsId) {
        return ServerResponse.createByErrorMessage("用户微服务调用失败!");
    }
}
