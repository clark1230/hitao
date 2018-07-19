package com.hzitxx.hitao.rpc;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.fallback.ShopCartServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 购物车接口
 */
@FeignClient(value = "product-service",fallback = ShopCartServiceHystrix.class)
public interface ShopCartService {
    /**
     * 获取会员购物车商品数量
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/cart/cartCount",method = RequestMethod.GET)
    public ServerResponse cartCount(@RequestParam("memberId") Integer memberId);
}
