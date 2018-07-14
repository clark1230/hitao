package com.hzitxx.hitao.controller.product;


import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopGoodsAttrTemplateService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrTemplate;
import com.hzitxx.hitao.vo.AttrTemp;
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
    @PostMapping("/save")
    public ServerResponse save(@RequestBody AttrTemp attrTemp){
        ShopGoodsAttrTemplate template = new ShopGoodsAttrTemplate();
        template.setAttrValue(JSON.toJSONString(attrTemp.getAttrTemp()));
        template.setCatId(attrTemp.getCatId());
        return  shopGoodsAttrTemplateService.addShopGoodsAttrTemplateSelective(template);
    }
    /**
     * 根据系统用户编号获取系统用户信息
     * @param adminId
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer adminId){
        return this.shopGoodsAttrTemplateService.findOne(adminId);
    }

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
    @GetMapping("/findAttr")
    public ServerResponse findAttr(@RequestParam Integer catId){
        return shopGoodsAttrTemplateService.findByCatId(catId);
    }

}
