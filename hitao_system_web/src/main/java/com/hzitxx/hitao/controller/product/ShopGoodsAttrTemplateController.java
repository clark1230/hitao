package com.hzitxx.hitao.controller.product;


import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopGoodsAttrTemplateService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrTemplate;
import com.hzitxx.hitao.vo.AttrTemp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品属性模板表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
@Api(value = "属性模板Controller",tags = "{属性模板接口}")
@RestController
@RequestMapping("/shopGoodsAttrTemplate")
public class ShopGoodsAttrTemplateController  {

    @Autowired
    private IShopGoodsAttrTemplateService shopGoodsAttrTemplateService;



    /**
     * 属性模板
     * @param attrTemp
     * @return
     */
    @ApiOperation(value = "保存属性模板",tags = "save", notes = "保存属性模板信息")
    @PostMapping("/save")
    public ServerResponse save(@RequestBody AttrTemp attrTemp){
        ShopGoodsAttrTemplate template = new ShopGoodsAttrTemplate();
        template.setAttrValue(JSON.toJSONString(attrTemp.getAttrTemp()));
        template.setCatId(attrTemp.getCatId());
        return  shopGoodsAttrTemplateService.addShopGoodsAttrTemplateSelective(template);
    }
    /**
     *
     * @param adminId
     * @return
     */
   /* @ApiOperation(value = "获取属性模板",tags = "findOne", notes = "根据编号获取属性模板信息")
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer adminId){
        return this.shopGoodsAttrTemplateService.findOne(adminId);
    }*/

    /**
     * 处理修改数据表单提交
     * @return
     */
//    @PostMapping("update")
//    public ServerResponse update(ShopGoodsAttrTemplate shopGoodsAttrTemplate,Model model){
//        return shopGoodsAttrTemplateService.updateSelectiveById(shopGoodsAttrTemplate);
//    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
//    @GetMapping("removeBatch")
//    public ServerResponse removeBatch(String[] ids){
//       return shopGoodsAttrTemplateService.deleteByIds(ids);
//    }

    /**
     * 查询类目信息
     * @param catId
     * @return
     */
    @ApiOperation(value = "查询类目信息",tags = "findAttr", notes = "根据类目编号查询类目信息")
    @GetMapping("/findAttr")
    public ServerResponse findAttr(@RequestParam Integer catId){
        return shopGoodsAttrTemplateService.findByCatId(catId);
    }

}
