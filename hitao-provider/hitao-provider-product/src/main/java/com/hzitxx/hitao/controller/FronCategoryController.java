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

//@Api(value = "前台类目控制器",tags = "前台类目接口")
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
//    @ApiOperation(value = "获取前台类目",notes = "获取前台类目")
//    @ApiImplicitParam
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
//    @ApiOperation(value = "获取当前前台类目",notes = "获取当前前台类目")
//    @ApiImplicitParam(name = "frontCatId",value = "类目编号",paramType = "query",required = true,dataType = "int")
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
