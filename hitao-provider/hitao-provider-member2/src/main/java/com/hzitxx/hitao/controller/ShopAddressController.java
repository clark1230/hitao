package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.member.ShopAddress;
import com.hzitxx.hitao.service.IShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.HashMap;
import  java.util.Map;
/**
 * 收货地址控制器
 */
@RestController
//@Api(value = "ShopAddressController",tags = "收货地址控制器")
@RequestMapping("/shopAddress")
public class ShopAddressController {

    @Autowired
    private IShopAddressService shopAddressService;

    /**
     * 添加收货地址
     * @param shopAddress
     * @return
     */
    @PostMapping("/addShopAddress")
//    @ApiOperation(value = "添加收货地址",notes = "添加收货地址")
//    @ApiImplicitParam(name = "shopAddress",value = "收货地址封装实体",required = true,dataTypeClass = ShopAddress.class)
    public ServerResponse addShopAddress(@RequestBody  ShopAddress shopAddress){
        return this.shopAddressService.addShopAddressSelective(shopAddress);
    }

    /**
     * 获取收货地址列表
     * @return
     */
    @GetMapping("/list")
//    @ApiOperation(value = "获取收货地址",notes = "获取收货地址")
//    @ApiImplicitParam(name = "memberId",value = "会员编号",required = true,dataType = "int",paramType = "query")
    public ServerResponse list(@RequestParam("memberId") int memberId){
        System.out.println("添加收货地址...");
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("memberId",memberId);
        return this.shopAddressService.searchShopAddress(paramsMap);
    }

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
//    @ApiOperation(value = "删除收货地址",notes = "删除收货地址")
//    @ApiImplicitParam(name = "id",value="收货地址编号",required = true,paramType = "query",dataType = "int")
    public ServerResponse delete(@RequestParam("id") int id){
        return this.shopAddressService.deleteById(id);
    }

    /**
     * 获取收货地址详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
//    @ApiOperation(value = "获取收货地址详情",notes = "获取收货地址详情")
//    @ApiImplicitParam(name="id",value = "收货地址编号",required = true,paramType = "query",dataType = "int")
    public ServerResponse detail(@RequestParam("id") int id){
        return this.shopAddressService.findOne(id);
    }

    /**
     * 编辑收货地址
     * @param shopAddress
     * @return
     */
    @PostMapping("/updateShopAddress")
//    @ApiOperation(value = "编辑收货地址",notes = "编辑收货地址")
//    @ApiImplicitParam(name="shopAddress",value = "收货实体",required = true,dataType = "ShopAddress")
    public ServerResponse update(@RequestBody ShopAddress shopAddress){
        System.out.println("编辑收货地址");
        return this.shopAddressService.updateSelectiveById(shopAddress);
    }

    /**
     * 获取会员默认的收货地址
     * @param memberId 获取请求头中会员编号
     * @return
     */
    @GetMapping("/getDefaultAddress")
    public ServerResponse getDefaultAddress(@RequestHeader("memberid")Integer memberId){
        return  this.shopAddressService.searchDefaultAddress(memberId);
    }
}
