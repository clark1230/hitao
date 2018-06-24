package com.hzitxx.hitao.rpc.product;

import com.hzitxx.hitao.rpc.product.fallback.ShopGoodsHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service",fallback = ShopGoodsHystrix.class)
public interface ShopGoodsService {

    @RequestMapping(value = "/findGoods",method = RequestMethod.GET)
    public Object findGoods();

    @RequestMapping(value = "/goods/details",method = RequestMethod.GET)
    public Object details(@RequestParam("goodsId")int goodsId,@RequestParam("memberId") Integer memberId);
}
