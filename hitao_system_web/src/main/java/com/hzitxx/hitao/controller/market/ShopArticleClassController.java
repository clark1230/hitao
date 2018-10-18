package com.hzitxx.hitao.controller.market;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.market.IShopArticleClassService;
import com.hzitxx.hitao.system.pojo.market.ShopArticleClass;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 文章分类表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
@RestController
@RequestMapping("/shopArticleClass")
public class ShopArticleClassController  {

    @Autowired
    private IShopArticleClassService shopArticleClassService;

    /**
     * 分页
     * @return
     */
    @GetMapping(value="/showData")
    @ResponseBody
    public ServerResponse<LayuiEntity<ShopArticleClass>> shopArticleClassAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                                              @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        return shopArticleClassService.page(page,limit,map);
    }


    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "/save")
    public ServerResponse save(@RequestBody ShopArticleClass shopArticleClass){
        shopArticleClass.setCreatedTime(new Date());
        return shopArticleClassService.addShopArticleClassSelective(shopArticleClass);
    }

    /**
     * 根据系统用户编号获取系统用户信息
     * @param acId
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer acId){
        return this.shopArticleClassService.findOne(acId);
    }

    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("/update")
    public ServerResponse update(@RequestBody ShopArticleClass shopArticleClass){
        shopArticleClass.setUpdatedTime(new Date());
        return shopArticleClassService.updateSelectiveById(shopArticleClass);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @GetMapping("/removeBatch")
    public ServerResponse removeBatch(String[] ids){
       return shopArticleClassService.deleteByIds(ids);
    }

    /**
     * 根据id删除数据
     * @param acId
     * @return
     */
    @GetMapping("/remove")
    public ServerResponse remove(@RequestParam("acId") Integer acId){
        return this.shopArticleClassService.deleteById(acId);
    }
}
