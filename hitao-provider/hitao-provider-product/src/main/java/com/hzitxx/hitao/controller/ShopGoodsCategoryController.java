package com.hzitxx.hitao.controller;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.ShopGoodsCategoryService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.AttrTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 * 商品分类表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-05
 */
@RestController
@RequestMapping("/shopGoodsCategory")
public class ShopGoodsCategoryController  {

    @Autowired(required = false)
    private ShopGoodsCategoryService shopGoodsCategoryService;


    /**
     * 分页
     * @return
     */
    @GetMapping(value="shopGoodsCategoryAjax")
    @ResponseBody
    public ServerResponse<LayuiEntity<ShopGoodsCategory>> shopGoodsCategoryAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                                                @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        return shopGoodsCategoryService.page(page,limit,map);
    }



    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "save")
    public ServerResponse save(ShopGoodsCategory shopGoodsCategory,Model model){
        return shopGoodsCategoryService.addShopGoodsCategorySelective(shopGoodsCategory);
    }

    /**
     * 根据系统用户编号获取系统用户信息
     * @param adminId
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer adminId){
        return this.shopGoodsCategoryService.findOne(adminId);
    }


/**
 * 处理修改数据表单提交
 * @return
 */
    @PostMapping("update")
    public ServerResponse update(ShopGoodsCategory shopGoodsCategory,Model model){
        return shopGoodsCategoryService.updateSelectiveById(shopGoodsCategory);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @GetMapping("removeBatch")
    public ServerResponse removeBatch(String[] ids){
       return shopGoodsCategoryService.deleteByIds(ids);
    }



}
