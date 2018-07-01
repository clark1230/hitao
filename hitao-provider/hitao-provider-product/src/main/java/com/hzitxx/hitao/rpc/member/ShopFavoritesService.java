package com.hzitxx.hitao.rpc.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface ShopFavoritesService {
    /**
     * 检查该商品是否被收藏了
     * @param memberId
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/shopFavorites/checkFavorites",method = RequestMethod.GET)
    public ServerResponse<ShopFavorites> checkFavorites(@RequestParam("memberId")Integer memberId,
                                                        @RequestParam("goodsId")Integer goodsId);
}
