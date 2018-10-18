package com.hzitxx.hitao.controller.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopGoodsCategoryService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.util.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(value = "属性Controller",tags = "{属性接口}")
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
    @ApiOperation(value = "获取属性分页信息",tags = "showData", notes = "获取属性分页信息")
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
    @ApiOperation(value = "保存属性",tags = "save", notes = "保存属性信息")
    @PostMapping(value = "save")
    public ServerResponse save(@RequestBody ShopGoodsCategory shopGoodsCategory){
        shopGoodsCategory.setCreatedTime(new Date());
        return shopGoodsCategoryService.addShopGoodsCategorySelective(shopGoodsCategory);
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
    @ApiOperation(value = "编辑属性",tags = "showData", notes = "编辑属性信息")
    @PostMapping("update")
    public ServerResponse update(@RequestBody ShopGoodsCategory shopGoodsCategory){
        shopGoodsCategory.setUpdatedTime(new Date());
        return shopGoodsCategoryService.updateSelectiveById(shopGoodsCategory);
    }

    /**
     * 根据id批量删除数据
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除属性",tags = "removeBatch", notes = "物理批量删除属性信息")
    @GetMapping("removeBatch")
    public ServerResponse removeBatch(String[] ids){
        return shopGoodsCategoryService.deleteByIds(ids);
    }

    /**
     * 删除商品类目
     * @return
     */
    @ApiOperation(value = "删除属性",tags = "remove", notes = "批量删除属性")
    @GetMapping("/remove")
    public ServerResponse remove(ShopGoodsCategory shopGoodsCategory){
        return shopGoodsCategoryService.updateSelectiveById(shopGoodsCategory);
    }

    /**
     * 根据catId 查询数据
     * @param catId
     * @return
     */
    @ApiOperation(value = "获取属性",tags = "findOne", notes = "根据属性编号查询属性编号")
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer catId){
        return  this.shopGoodsCategoryService.findOne(catId);
    }


    /**
     * 根据父级编号查询类目信息
     * @param pId
     * @return
     */
    @ApiOperation(value = "根据父级编号",tags = "findByPId", notes = "根据父级编号编号获取类目信息")
    @GetMapping("/findByPId")
    public ServerResponse findByPId(@RequestParam Integer pId){
        return this.shopGoodsCategoryService.findByPId(pId);
    }


}
