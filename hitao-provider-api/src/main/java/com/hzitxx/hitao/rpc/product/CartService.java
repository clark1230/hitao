package com.hzitxx.hitao.rpc.product;

import com.hzitxx.hitao.rpc.product.fallback.CartHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 购物车服务负载均衡
 */
@FeignClient(value = "product-service",fallback = CartHystrix.class)
public interface CartService {
    /**
     * 库存检查
     * @param goodsId
     * @param number
     * @return
     */
    @RequestMapping(value = "/cart/checkout",method = RequestMethod.GET)
    public Object checkout(@RequestParam("goodsId")int goodsId, @RequestParam("number")int number);

    /**
     * 添加购物车信息
     * @param goodsId
     * @param number
     * @return
     */
    @RequestMapping(value = "/cart/add",method = RequestMethod.POST)
    public Object add(@RequestParam("goodsId")int goodsId,@RequestParam("number")int number,@RequestParam("memberId")int memberId);

    /**
     * 删除购物车信息
     * @return
     */
    @RequestMapping(value = "/cart/delete",method = RequestMethod.GET)
    public Object delete(@RequestParam("memberId")int memberId,@RequestParam("goodsIds")String goodsIds);

    /**
     * 编辑购物车信息
     * @param goodsId
     * @param number
     * @param mbmerId
     * @return
     */
    @RequestMapping(value = "/cart/update",method = RequestMethod.POST)
    public Object update(@RequestParam("goodsId")int goodsId,@RequestParam("number")int number,@RequestParam("memberId")int mbmerId);

    /**
     * 获取购物车信息
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/cart/cartList",method = RequestMethod.GET)
    public Object cartList(@RequestParam("memberId")int memberId);

    /**
     * 会员获取购物车商品数量
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/cart/cartCount",method = RequestMethod.GET)
    public Object cartCount(@RequestParam("memberId")int memberId);
}


