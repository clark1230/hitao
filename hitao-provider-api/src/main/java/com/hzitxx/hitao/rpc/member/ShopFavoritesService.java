package com.hzitxx.hitao.rpc.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.member.fallback.ShopFavoritesHystrix;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service",fallback = ShopFavoritesHystrix.class)
public interface ShopFavoritesService {
    /**
     * 添加获取取消商品收藏
     * @return
     */
    @RequestMapping(value = "/shopFavorites/addOrDelete",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse<String> addOrDelete(@RequestBody ShopFavorites shopFavorites,@RequestParam("type")Integer type);
}
