package com.hzitxx.hitao.controller.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.product.ShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopGoodsController {

    @Autowired
    private ShopGoodsService goodsService;

    @GetMapping("goods/count")
    public Object count(){
        return ServerResponse.createBySuccess(10);
    }

    @GetMapping("/findGoods")
    public Object findGoods(){
        return this.goodsService.findGoods();
    }

    /**
     * 商品详情
     * @return
     */
    @GetMapping("/goods/details")
    public Object details(@RequestParam("id")int goodsId,@RequestParam("memberId") Integer memberId){
        return this.goodsService.details(goodsId,memberId);
    }
}
