package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.IShopAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import  java.util.Map;
@RestController
@RequestMapping("/shopArea")
//@Api(value = "ShopAreaController",tags = "省市区接口")
public class ShopAreaController {

    @Autowired
    private IShopAreaService shopAreaService;
//    @ApiOperation(value = "获取省市区信息",notes = "获取省市区信息")
//    @ApiImplicitParam(name = "parentId",value="父级编号",required = true,paramType = "query",dataType = "int",defaultValue = "0")
    @GetMapping("/getShopArea")
    public ServerResponse getShopArea(@RequestParam(value = "parentId",defaultValue = "0")int parentId){
        Map<String,Object> map = new HashMap<>();
        map.put("areaParentId",parentId);
        return this.shopAreaService.searchShopArea(map);
    }
}
