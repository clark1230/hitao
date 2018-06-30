package com.hzitxx.hitao.rpc.member.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.member.ShopFavoritesService;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.springframework.stereotype.Service;

@Service
public class ShopFavoritesHystrix implements ShopFavoritesService {

    @Override
    public ServerResponse<String> addOrDelete(ShopFavorites shopFavorites,Integer type) {
        return ServerResponse.createByErrorMessage("会员服务调用失败!");
    }
}
