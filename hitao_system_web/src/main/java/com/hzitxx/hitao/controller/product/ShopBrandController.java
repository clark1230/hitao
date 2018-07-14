package com.hzitxx.hitao.controller.product;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopBrandService;
import com.hzitxx.hitao.system.pojo.product.ShopBrand;
import com.hzitxx.hitao.util.LayuiEntity;
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
@RestController
@RequestMapping("/shopBrand")
public class ShopBrandController  {

    @Autowired(required = false)
    private IShopBrandService shopBrandService;

    /**
     * 分页
     * @return
     */
    @GetMapping(value="shopBrandAjax")
    public ServerResponse<LayuiEntity<ShopBrand>> shopBrandAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                                                String value){
        Map<String,Object>  map = new HashMap<>();
        if(StringUtils.isNotBlank(value)){
            map.put("brandName",value);
        }
        return shopBrandService.page(page,limit,map);
    }

    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "/save")
    public ServerResponse save(@RequestBody  ShopBrand shopBrand){
        shopBrand.setCreatedTime(new Date());
        return shopBrandService.addShopBrandSelective(shopBrand);
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
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
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return this.shopBrandService.deleteByIds(ids);
    }

    /**
     * 根据品牌编号查询品牌信息
     * @param brandId
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer brandId){
        return  this.shopBrandService.findOne(brandId);
    }

    /**
     * 批量逻辑删除数据
     * @return
     */
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
    public ServerResponse remove(ShopBrand shopBrand){
        shopBrand.setIsDel(1);
        return this.shopBrandService.updateSelectiveById(shopBrand);
    }

    /**
     * 根据类目编号查询品牌信息
     * @param classId  类目编号
     */
    @GetMapping("/findByClassId")
    public ServerResponse findByClassId(Integer classId){
        Map<String,Object> params = new HashMap<>();
        params.put("classId",classId);
        return this.shopBrandService.searchShopBrand(params);
    }
}
