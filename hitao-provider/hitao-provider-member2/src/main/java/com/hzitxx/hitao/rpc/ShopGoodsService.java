package com.hzitxx.hitao.rpc;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.fallback.ShopGoodsSerivceHystrix;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service",fallback = ShopGoodsSerivceHystrix.class)
public interface ShopGoodsService {

    /**
     * 根据商品编号查询商品信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/shopGoods/findById",method = RequestMethod.GET)
    public ServerResponse<ShopGoods> findById(@RequestParam("goodsId") Integer goodsId);
}
