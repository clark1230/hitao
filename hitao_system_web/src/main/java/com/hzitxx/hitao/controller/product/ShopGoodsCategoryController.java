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

    @GetMapping("/treeData")
    public ServerResponse treeData(){
        return shopGoodsCategoryService.ajaxCate();
    }


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


    /**
     * 根据父级编号查询类目信息
     * @param pId
     * @return
     */
    @GetMapping("/findByPId")
    public ServerResponse findByPId(@RequestParam Integer pId){
        return this.shopGoodsCategoryService.findByPId(pId);
    }


}
