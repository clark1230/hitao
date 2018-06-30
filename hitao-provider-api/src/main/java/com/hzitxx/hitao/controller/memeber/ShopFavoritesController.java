package com.hzitxx.hitao.controller.memeber;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.member.ShopFavoritesService;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品收藏控制器
 */
@RestController
@RequestMapping("/shopFavorites")
public class ShopFavoritesController {
    @Autowired
    private ShopFavoritesService shopFavoritesService;

    /**
     * 添加获取取消收藏
     * @return
     */
    @PostMapping("/addOrDelete")
    public ServerResponse addOrDelete(@RequestBody  ShopFavorites shopFavorites,
                                      @RequestParam(value = "type",defaultValue = "0") Integer type){
        System.out.println(shopFavorites);
        return this.shopFavoritesService.addOrDelete(  shopFavorites,type);
    }

}
