package com.hzitxx.hitao.controller.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopGoodsCategoryService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shopGoodsCategory")
public class ShopGoodsCategoryController {
    @Autowired
    private IShopGoodsCategoryService shopGoodsCategoryService;

    @GetMapping("/ajaxCate")
    public Object ajaxCate(){
        return shopGoodsCategoryService.ajaxCate();
    }


    /**
     * 分页
     * @return
     */
    @GetMapping(value="shopGoodsCategoryAjax")
    @ResponseBody
    public LayuiEntity<ShopGoodsCategory> shopGoodsCategoryAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                                @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        LayuiEntity<ShopGoodsCategory> layuiEntity = shopGoodsCategoryService.page(page,limit,map);
        return layuiEntity;
    }


    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "addShopGoodsCategory")
    public ServerResponse addShopGoodsCategory(ShopGoodsCategory shopGoodsCategory){
        return shopGoodsCategoryService.addShopGoodsCategorySelective(shopGoodsCategory);
    }




    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("editShopGoodsCategory")
    public ServerResponse editShopGoodsCategory(ShopGoodsCategory shopGoodsCategory){
        return shopGoodsCategoryService.updateSelectiveById(shopGoodsCategory);
    }

    /**
     * 根据id批量删除数据
     * @param ids
     * @return
     */
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return shopGoodsCategoryService.deleteByIds(ids);
    }

    /**
     * 根据catId 查询数据
     * @param catId
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer catId){
        return  this.shopGoodsCategoryService.findOne(catId);
    }
}
