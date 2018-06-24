package com.hzitxx.hitao.controller.product;

import com.hzitxx.hitao.rpc.product.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired(required = false)
    private CartService cartService;

    /**
     * 库存检查
     * @param goodsId
     * @param number
     * @return
     */
    @GetMapping("/checkout")
    public Object checkout(@RequestParam("goodsId")int goodsId,@RequestParam("number") int number){
        return this.cartService.checkout(goodsId,number);
    }

    /**
     * 添加购物车信息
     * @param goodsId
     * @param memberId
     * @return
     */
    @PostMapping("/add")
    public Object add(@RequestParam("goodsId")int goodsId,
                      @RequestParam("number")int number,
                      @RequestParam("memberId")int memberId){
        return this.cartService.add(goodsId, number,memberId);
    }

    /**
     * 删除购物车信息
     * @param memberId
     * @param goodsIds
     * @return
     */
    @GetMapping("/delete")
    public Object delete(@RequestParam("memberId")int memberId,
                         @RequestParam("goodsIds")String goodsIds){
        return this.cartService.delete(memberId,goodsIds);
    }

    /**
     * 编辑购物车信息
     * @return
     */
    @PostMapping("/update")
    public Object update(@RequestParam("goodsId")int goodsId,
                         @RequestParam("number")int number,
                         @RequestParam("memberId")int memberId){
        return this.cartService.update(goodsId, number, memberId);
    }
    /**
     * 获取购物车信息
     * @param memberId
     * @return
     */
    @GetMapping("/cartList")
    public Object cartList(@RequestParam("memberId")int memberId){
        return this.cartService.cartList(memberId);
    }

    /**
     * 会员获取购物车商品数量
     * @param memberId
     * @return
     */
    @GetMapping("/cartCount")
    public Object cartCount(@RequestParam("memberId")int memberId){
        return this.cartService.cartCount(memberId);
    }
}
