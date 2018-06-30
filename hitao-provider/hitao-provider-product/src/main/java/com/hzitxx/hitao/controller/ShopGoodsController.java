package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.product.ShopGoods;
import com.hzitxx.hitao.rpc.product.ShopGoodsService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Api(value = "ShopGoodsController",tags = "商品接口")
@RestController
public class ShopGoodsController {
    @Autowired
    private ShopGoodsService goodsService;

    /**
     * 获取商品信息
     * @return
     */
//    @ApiOperation(value = "获取商品信息",notes = "获取商品信息")
    @GetMapping("/findGoods")
    public Object findGoods(){
        return this.goodsService.findGoods();
    }

    /**
     * 获取商品详情
     * @param goodsId
     * @return
     */
//    @ApiOperation(value = "获取商品详情",notes = "获取商品详情")
//    @ApiImplicitParam(value = "商品编号",name = "id",paramType = "query",required = true,dataType = "Integer")
    @GetMapping("/goods/details")
    public Object details(@RequestParam("goodsId")Integer goodsId,@RequestParam("memberId") Integer memberId){
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
}
