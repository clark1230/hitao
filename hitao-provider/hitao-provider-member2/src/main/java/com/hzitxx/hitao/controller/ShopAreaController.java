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
public class ShopAreaController {

    @Autowired
    private IShopAreaService shopAreaService;
    @GetMapping("/getShopArea")
    public ServerResponse getShopArea(@RequestParam(value = "parentId",defaultValue = "0")int parentId){
        Map<String,Object> map = new HashMap<>();
        map.put("areaParentId",parentId);
        return this.shopAreaService.searchShopArea(map);
    }
}
