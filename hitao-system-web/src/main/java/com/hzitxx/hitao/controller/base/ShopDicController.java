package com.hzitxx.hitao.controller.base;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.IShopDicService;
import com.hzitxx.hitao.system.pojo.ShopDic;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/shopDic")
public class ShopDicController  {

    @Autowired
    private IShopDicService shopDicService;

    /**
     * 分页
     *
     * @return
     */
    @GetMapping(value = "/showData")
    @ResponseBody
    public ServerResponse<LayuiEntity<ShopDic>> showData(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                         @RequestParam(value = "limit", defaultValue = "20") Integer limit,
                                                         @RequestParam(value = "parentId") Integer parentId,
                                                         String value) {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId",parentId);
        return shopDicService.page(page, limit, map);
    }

    /**
     * 获取数据字典分类信息
     * @return
     */
    @GetMapping(value="tabData")
    public ServerResponse<List<ShopDic>> tabData(){
        return shopDicService.searchShopDic(new HashMap<String,Object>(){{
            put("parentId",0);
        }});
    }
    /**
     * 处理添加表单
     *
     * @param
     * @return
     */
    @PostMapping(value = "/save")
    public ServerResponse save(ShopDic shopDic) {
        shopDic.setCreatedTime(new Date());
        return shopDicService.addShopDicSelective(shopDic);
    }

    /**
     * 根据系统用户编号获取系统用户信息
     *
     * @param dicId
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer dicId) {
        return this.shopDicService.findOne(dicId);
    }


    /**
     * 处理修改数据表单提交
     *
     * @return
     */
    @PostMapping("/update")
    public ServerResponse update(ShopDic shopDic) {
        shopDic.setUpdatedTime(new Date());
        return shopDicService.updateSelectiveById(shopDic);
    }

    /**
     * 修改字典数据状态
     * @param shopDic
     * @return
     */
    @GetMapping("/remove")
    public ServerResponse changeStatus(ShopDic shopDic){
        shopDic.setUpdatedTime(new Date());
        return shopDicService.updateSelectiveById(shopDic);
    }

}
