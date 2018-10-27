package com.hzitxx.hitao.controller;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.IShopFavoritesService;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import com.hzitxx.hitao.utils.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 买家收藏表 前端控制器
 * </p>
 * @author xianyaoji
 * @since 2018-06-08
 */
@RestController
@RequestMapping("/shopFavorites")
public class ShopFavoritesController  {

    @Autowired
    private IShopFavoritesService shopFavoritesService;

    /**
     * 获取分页数据
     * @param page
     * @param limit
     * @param memberId
     * @return
     */
    @GetMapping("/list")
    public ServerResponse<LayuiEntity<ShopFavorites>> page(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                                           @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                                           @RequestParam(value = "memberId") Integer memberId) {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId",memberId);
        return shopFavoritesService.page(page,limit,map);
    }
    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "/addOrDelete")
    public ServerResponse addOrDelete(@RequestBody ShopFavorites shopFavorites,
                                      @RequestParam(value = "type",defaultValue = "0")Integer type){
        return shopFavoritesService.addOrDelete(shopFavorites,type);
    }
                            

    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("/editShopFavorites")
    public ServerResponse editShopFavorites(ShopFavorites shopFavorites,Model model){
        return shopFavoritesService.updateSelectiveById(shopFavorites);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @GetMapping("/deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return shopFavoritesService.deleteByIds(ids);
    }

    /**
     * 根据favId查询收藏信息
     * @param favId
     * @return
     */
    @GetMapping("/findById")
    public ServerResponse<ShopFavorites> findOne(@RequestParam("favId")Integer favId){
        return shopFavoritesService.findOne(favId);
    }

    /**
     * 检查收藏信息
     * @param memberId
     * @param goodsId
     * @return
     */
    @GetMapping("/checkFavorites")
    public ServerResponse<ShopFavorites> checkFavorites( @RequestParam("memberId")Integer memberId,
                                                         @RequestParam("goodsId")Integer goodsId){
        return this.shopFavoritesService.checkFavorites(memberId,goodsId);
    }

    /**
     * 删除收藏信息
     * @param favId
     * @return
     */
    @GetMapping("/deleteShopFavorites")
    public ServerResponse deleteShopFavorites(@RequestParam("favId") Integer favId) {
        return this.shopFavoritesService.deleteById(favId);
    }
}
