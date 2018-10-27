package com.hzitxx.hitao.controller.base;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.member.IShopAreaService;
import com.hzitxx.hitao.system.pojo.member.ShopArea;
import com.hzitxx.hitao.util.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
@Api(value = "区域Controller",tags = "{区域管理接口}")
@RestController
@RequestMapping("/shopArea")
public class ShopAreaController  {
    @Autowired
    private IShopAreaService shopAreaService;

    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "获取区域信息",notes = "获取区域信息")
    @GetMapping(value="shopAreaAjax")
    @ResponseBody
    public ServerResponse<LayuiEntity<ShopArea>> shopAreaAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                              @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                              String areaName){
        Map<String,Object>  map = new HashMap<>();
        if(!StringUtils.isEmpty(areaName)){
            map.put("areaName",areaName);
        }
        return shopAreaService.page(page,limit,map);
    }



    /**
     * 处理添加表单
     * @param
     * @return
     */
    @ApiOperation(value = "保存区域信息",notes = "save")
    @PostMapping(value = "/save")
    public ServerResponse save(@RequestBody ShopArea shopArea){
        shopArea.setCreatedTime(new Date());
        return shopAreaService.addShopAreaSelective(shopArea);
    }

    /**
     * 根据id查询数据
     * @param areaId
     * @return
     */
    @ApiOperation(value = "获取区域信息",notes = "findOne")
    @GetMapping(value = "/findOne")
    public ServerResponse findOne(@RequestParam("areaId") int areaId){
        return  shopAreaService.findOne(areaId);
    }

    /**
     * 处理修改数据表单提交
     * @return
     */
    @ApiOperation(value = "编辑区域信息",notes = "update")
    @PostMapping("/update")
    public ServerResponse update(@RequestBody  ShopArea shopArea){
        shopArea.setUpdatedTime(new Date());
        return shopAreaService.updateSelectiveById(shopArea);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @ApiOperation(value = "批量删除区域信息",notes = "deleteBatch")
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return shopAreaService.deleteByIds(ids);
    }

    /**
     * 根据区域名称查询区域信息
     * @return
     */
    @ApiOperation(value = "查询区域信息",notes = "findShopArea")
    @GetMapping("/findShopArea")
    public ServerResponse findShopArea(@RequestParam("areaName")String areaName){
        Map<String,Object> paramsMap = new HashMap<String,Object>(){{
            put("areaName",areaName);
        }};
        return this.shopAreaService.searchShopArea(paramsMap);
    }

    /**
     * 逻辑删除区域信息
     * @param shopArea
     * @return
     */
    @GetMapping("/removeShopArea")
    public ServerResponse removeShopArea(ShopArea shopArea){
        return this.shopAreaService.updateSelectiveById(shopArea);
    }
}
