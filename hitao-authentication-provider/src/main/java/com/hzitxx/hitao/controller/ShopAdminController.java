package com.hzitxx.hitao.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.service.IShopAdminService;
import com.hzitxx.hitao.service.IShopPermissionRouteService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.ShopAdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/shopAdmin")
@Api(value = "系统管理员Controller",tags = "{系统管理员接口}")
public class ShopAdminController {

    @Autowired
    private IShopAdminService shopAdminService;

    @Autowired
    private IShopPermissionRouteService permissionRouteService;

    @Autowired
    private Audience audience;

    /**
     * 获取系统管理员信息
     * @return
     */
    @ApiOperation(value = "获取管理员信息",tags = "showData", notes = "获取管理员分页后的数据(包含搜索)")
    @GetMapping("/showData")
    public ServerResponse<LayuiEntity<ShopAdminVO>> showData(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                                  @RequestParam(value = "limit",defaultValue = "20")Integer limit,
                                                  String adminName){
        Map<String,Object> map = new HashMap<>();
        if(!StringUtils.isEmpty(adminName)){
            map.put("adminName",adminName);
        }
        return this.shopAdminService.page(page,limit,map);
    }

    /**
     * 获取后台用户信息
     * @return
     */
    @GetMapping("/info")
    @ApiOperation(value = "获取管理员信息",tags = "info", notes = "获取管理员信息")
    public ServerResponse info(@RequestHeader("token")String token){
        JSONObject jsonObject = new JSONObject();
        List<String> roleList = new ArrayList<>();
        //组装数据
        roleList.add("admin");
        jsonObject.put("roles",roleList);
        jsonObject.put("permissions",permissionRouteService
                .menuTree().getData());

        jsonObject.put("avatar","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=925993276,4023638545&fm=27&gp=0.jpg");
        ShopAdmin shopAdmin = this.shopAdminService.login(
                JwtHelper.parseJWT(token, audience.getBase64Secret()).get("unique_name").toString());
        shopAdmin.setAdminPassword(null);
        jsonObject.put("shopAdmin",shopAdmin);
        return  ServerResponse.createBySuccess(jsonObject);
    }

    /**
     * 编辑系统用户信息
     * @param shopAdmin
     * @param token
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "编辑管理员信息",tags = "update", notes = "编辑管理员信息")
    public ServerResponse update(@RequestBody  ShopAdmin shopAdmin,
                                 @RequestHeader("token") String token){
        shopAdmin.setUpdatedTime(new Date());
        shopAdmin.setUpdatedBy(JwtHelper.getUserId(token,audience.getBase64Secret()));
        return this.shopAdminService.updateSelectiveById(shopAdmin);
    }

    /**
     * 添加系统用户信息
     * @param shopAdmin
     * @param token
     * @return
     */
    @ApiOperation(value = "获取管理员信息",tags = "save", notes = "获取管理员信息(包含基本信息，权限，角色等)")
    @PostMapping("/save")
    public ServerResponse save(@RequestBody  ShopAdmin shopAdmin,
                                       @RequestHeader("token") String token){
        shopAdmin.setLoginStatus(0);
        shopAdmin.setCreatedTime(new Date());
        shopAdmin.setCreatedBy(JwtHelper.getUserId(token,audience.getBase64Secret()));
        return this.shopAdminService.addShopAdminSelective(shopAdmin);
    }

    /**
     * 根据系统用户编号获取系统用户信息
     * @param adminId
     * @return
     */
    @ApiOperation(value = "根据编号获取用户信息",tags = "findOne", notes = "获取管理员信息")
    @GetMapping("/findOne")
    public ServerResponse findOne(@RequestParam("adminId") Integer adminId){
        return this.shopAdminService.findOne(adminId);
    }

    /**
     * 根据adminId删除系统用户信息
     * @param adminId
     * @return
     */
    @ApiOperation(value = "删除管理员信息",tags = "remove", notes = "删除管理员信息")
    @GetMapping("/remove")
    public ServerResponse remove(Integer adminId){
        return this.shopAdminService.deleteById(adminId);
    }

    /**
     * 批量删除
     * @param adminIds
     * @return
     */
    @ApiOperation(value = "批量删除管理员信息",tags = "removeBatch", notes = "批量删除管理员信息")
    @GetMapping("/removeBatch")
    public ServerResponse removeBatch(String[] adminIds){
            return this.shopAdminService.deleteByIds(adminIds);

    }

    /**
     * 检查用户是否存在
     * @return
     */
    @ApiOperation(value = "检查管理员是否存在",tags = "checkExists", notes = "检查管理员是否存在")
    @GetMapping("/checkExists")
    public ServerResponse checkExists(String adminName){
        return this.shopAdminService.checkAdminNameExists(adminName);
    }

    /**
     * 为用户授予角色
     * @return
     */
    @ApiOperation(value = "授予角色",tags = "grantRole", notes = "为用户授予角色")
    @GetMapping("/grantRole")
    public ServerResponse<String> grantRole(@RequestParam("adminIds") Integer[] adminIds,
                                            @RequestParam("roleIds") Integer[] roleIds){
        return this.shopAdminService.grantRole(adminIds,roleIds);
    }

    /**
     * 根据管理员编号获取角色编号
     * @return
     */
    @ApiOperation(value = "获取角色信息",tags = "findRoleByAdmindId", notes = "根据管理员编号查询角色编号，以便角色回显")
    @GetMapping("/findRoleByAdmindId")
    public ServerResponse<List<Integer>> findRoleByAdminId(@RequestParam("adminId") Integer adminId){
        return this.shopAdminService.findRoleByAdminId(adminId);
    }

}
