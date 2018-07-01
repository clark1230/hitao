package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.product.ShopFrontCategoryService;
import com.hzitxx.hitao.rpc.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FronCategoryController {
    @Autowired
    private ShopFrontCategoryService frontCategoryService;

    @Autowired
    private MemberService memberService;

    /**
     * 获取一级类目
     * @return
     */
    @GetMapping(value = "/frontCate",produces = "application/json")
    public ServerResponse forntCate(){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("level",1);
        return frontCategoryService.searchShopFrontCategory(paramsMap);
    }

    /**
     * 获取当前类目
     * @param frontCatId
     * @return
     */
    @GetMapping(value = "/currentCate",produces = "application/json")
    public ServerResponse currentCate(@RequestParam("frontCatId") Integer frontCatId){
        return frontCategoryService.currentCategory(frontCatId);
    }

    /**
     * 调用用户微服务
     * @return
     */
    @GetMapping(value = "/getUser",produces = "application/json")
    public Object getUser(){
        System.out.println("调用用户微服务!");
        return "success";
    }

}
