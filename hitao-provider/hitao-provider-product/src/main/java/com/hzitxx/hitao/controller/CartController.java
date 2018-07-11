package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.entity.ShopGoodsCart;
import com.hzitxx.hitao.service.ShopCartService;
import com.hzitxx.hitao.service.ShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 购物车控制器
 */
//@Api(value = "购物车Controller",tags = "购物车接口")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private ShopGoodsService shopGoodsService;

    /**
     * 添加购物车之前的库存检查
     */
    @GetMapping("/checkout")
    public Object checkout(@RequestParam("goodsId")int goodsId,@RequestParam("number")int number){
        return this.shopGoodsService.checkout(goodsId,number);
    }

    /**
     * 保存购物车信息
     * 保存一份到数据库中(为了避免redis缓存雪崩导致数据的丢失问题)
     * 保存一份到redis数据库中(为了快速查询)
     * @param goodsId
     * @param number
     * @return
     */
//    @ApiOperation(value = "添加购物车商品",notes = "添加购物车商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "商品编号",name = "goodsId",paramType = "query",required = true,defaultValue = "int"),
//            @ApiImplicitParam(value = "数量",name = "number",paramType = "query",required = true,defaultValue = "int"),
//            @ApiImplicitParam(value = "会员编号",name = "memberId",paramType = "query",required = true,defaultValue = "int")
//    })
    @PostMapping("/add")
    public Object add(@RequestParam("goodsId")int goodsId,//商品编号
                      @RequestParam("number")int number,//商品数量
                      @RequestParam("memberId")int memberId){ //会员编号
        ShopGoodsCart shopGoodsCart = new ShopGoodsCart();
        shopGoodsCart.setGoodsId(goodsId);
        shopGoodsCart.setNumber(number);
        return shopCartService.addCart(memberId,shopGoodsCart);
    }

    /**
     * 删除购物车信息
     * @param goodsIds
     * @param memberId
     * @return
     */
//    @ApiOperation(value = "删除购物车信息",notes = "删除购物车信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "商品编号",name = "goodsIds",paramType = "query",required = true,dataType = "Long[]"),
//            @ApiImplicitParam(value = "会员编号",name = "memberId",paramType = "query",required = true,dataType = "int")
//    })
    @GetMapping("/delete")
    public Object delete(@RequestParam("goodsIds")Long[] goodsIds,
                         @RequestParam("memberId")int memberId){

        System.out.println("编号:"+ Arrays.toString(goodsIds));
        return this.shopCartService.deleteCart(memberId, goodsIds);
    }

    /**
     * 编辑购物车信息
     * @param goodsId
     * @param memberId
     * @param number
     * @return
     */
//    @ApiOperation(value = "编辑购物车信息",notes = "编辑购物车信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "商品编号",name = "goodsId",paramType = "query",required = true,dataType = "int"),
//            @ApiImplicitParam(value = "会员编号",name = "memberId",paramType = "query",required = true,dataType = "int"),
//            @ApiImplicitParam(value = "数量",name = "number",paramType = "query",required = true,dataType = "int")
//    })
    @PostMapping("/update")
    public Object update(@RequestParam("goodsId")int goodsId,
                         @RequestParam("memberId")int memberId,
                         @RequestParam("number")int number){
        ShopGoodsCart goodsCart = new ShopGoodsCart();
        goodsCart.setGoodsId(goodsId);
        goodsCart.setNumber(number);
        return this.shopCartService.update(memberId,goodsCart);
    }
    /**
     * 获取购物车信息
     * @param memberId
     * @return
     */
//    @ApiOperation(value = "获取购物车信息",notes = "获取购物车信息")
//    @ApiImplicitParam(value = "会员编号",name = "memberId",paramType = "query",required = true,dataType = "int")
    @GetMapping("/cartList")
    public Object cartList(@RequestParam("memberId") int memberId){
        return this.shopCartService.cartList(memberId);
    }

    /**
     * 获取会员购物时车的商品信息
     * @param memberId
     * @return
     */
//    @ApiOperation(value = "获取购物车商品数量",notes = "获取购物车商品数量")
//    @ApiImplicitParam(value = "会员编号",name = "memberId",paramType = "query",required = true,dataType = "int")
    @GetMapping("/cartCount")
    public Object cartCount(@RequestParam("memberId") int memberId){
        return this.shopCartService.cartCount(memberId);
    }

}
