package com.hzitxx.hitao.controller.product;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopBrandService;
import com.hzitxx.hitao.system.pojo.product.ShopBrand;
import com.hzitxx.hitao.util.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-28
 */
@Api(value = "品牌Controller",tags = "{商品品牌接口}")
@RestController
@RequestMapping("/shopBrand")
public class ShopBrandController  {

    @Autowired(required = false)
    private IShopBrandService shopBrandService;

    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "品牌分页数据",tags = "showData", notes = "获取品牌分页数据")
    @GetMapping(value="shopBrandAjax")
    public ServerResponse<LayuiEntity<ShopBrand>> shopBrandAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                                                String brandName){
        Map<String,Object>  map = new HashMap<>();
        if(StringUtils.isNotBlank(brandName)){
            map.put("brandName",brandName);
        }
        return shopBrandService.page(page,limit,map);
    }

    /**
     * 处理添加表单
     * @param
     * @return
     */
    @ApiOperation(value = "保存品牌信息",tags = "save", notes = "保存品牌信息")
    @PostMapping(value = "/save")
    public ServerResponse save(@RequestBody  ShopBrand shopBrand){
        shopBrand.setCreatedTime(new Date());
        return shopBrandService.addShopBrandSelective(shopBrand);
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
    @ApiOperation(value = "编辑品牌信息",tags = "update", notes = "编辑品牌信息")
    @PostMapping("/update")
    public ServerResponse update(@RequestBody  ShopBrand shopBrand){
        shopBrand.setUpdatedTime(new Date());
        return this.shopBrandService.updateSelectiveById(shopBrand);

    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
   /* @ApiOperation(value = "批量删除品牌信息",tags = "deleteBatch", notes = "物理批量删除品牌信息")
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return this.shopBrandService.deleteByIds(ids);
    }*/

    /**
     * 根据品牌编号查询品牌信息
     * @param brandId
     * @return
     */
    @ApiOperation(value = "获取品牌信息",tags = "findOne", notes = "根据品牌编号查询品牌信息")
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer brandId){
        return  this.shopBrandService.findOne(brandId);
    }

    /**
     * 批量逻辑删除数据
     * @return
     */
    @ApiOperation(value = "批量删除数据",tags = "save", notes = "逻辑批量删除品牌信息")
    @DeleteMapping("/removeBatch")
    public ServerResponse removeBatch(Integer[] brandIds){
        return this.shopBrandService.removeBatch(brandIds);
    }

    /**
     * 逻辑删除数据
     * @param shopBrand
     * @return
     */
    @DeleteMapping("/remove")
    @ApiOperation(value = "删除数据",tags = "save", notes = "逻辑删除品牌信息")
    public ServerResponse remove(ShopBrand shopBrand){
        return this.shopBrandService.updateSelectiveById(shopBrand);
    }

    /**
     * 根据类目编号查询品牌信息
     * @param classId  类目编号
     */
    @ApiOperation(value = "根据类目编号查询品牌",tags = "findByClassId", notes = "根据类目编号查询品牌信息")
    @GetMapping("/findByClassId")
    public ServerResponse findByClassId(Integer classId){
        Map<String,Object> params = new HashMap<>();
        params.put("classId",classId);
        return this.shopBrandService.searchShopBrand(params);
    }
}
