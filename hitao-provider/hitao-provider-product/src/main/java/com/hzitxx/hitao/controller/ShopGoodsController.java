package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.product.ShopGoods;
import com.hzitxx.hitao.service.ShopGoodsService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopGoodsController {
    @Autowired
    private ShopGoodsService goodsService;

    /**
     * 获取商品信息
     * @return
     */
    @GetMapping("/findGoods")
    public Object findGoods(){
        return this.goodsService.findGoods();
    }

    /**
     * 获取商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/goods/details")
    public Object details(@RequestParam("goodsId")Integer goodsId,
                          @RequestParam(value = "memberId",defaultValue = "0") Integer memberId){
        return this.goodsService.findOne(goodsId,memberId);
    }

    /**
     * 根据goodsId查询商品信息
     * @param goodsId
     * @return
     */
    @GetMapping("/shopGoods/findById")
    public ServerResponse<ShopGoods> findById(@RequestParam("goodsId") Integer goodsId){
        return this.goodsService.findById(goodsId);
    }

    /**
     * 查询商品数量
     * @return
     */
    @GetMapping("/shopGoods/goodsCount")
    public ServerResponse goodsCount(){
        return this.goodsService.goodsCount();
    }
}
