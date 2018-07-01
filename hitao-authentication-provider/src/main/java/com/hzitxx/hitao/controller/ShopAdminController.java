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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shopAdmin")
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
    @GetMapping("/shopAdminData")
    public LayuiEntity<ShopAdminVO> shopAdminData(@RequestParam(value = "page",defaultValue = "1")int page,
                                                  @RequestParam(value = "limit",defaultValue = "20")int limit){
        return this.shopAdminService.page(page,limit,null);
    }

    /**
     * 获取后台用户信息
     * @return
     */
    @GetMapping("/info")
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
     * 添加系统用户信息
     * @param shopAdmin
     * @param token
     * @return
     */
    @PostMapping("/addShopAdmin")
    public ServerResponse addShopAdmin(@RequestBody  ShopAdmin shopAdmin,
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
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer adminId){
        return this.shopAdminService.findOne(adminId);
    }

    /**
     * 编辑系统用户信息
     * @param shopAdmin
     * @param token
     * @return
     */
    @PostMapping("/editShopAdmin")
    public ServerResponse editShopAdmin(@RequestBody  ShopAdmin shopAdmin,
                                        @RequestHeader("token") String token){
        shopAdmin.setUpdatedTime(new Date());
        shopAdmin.setUpdatedBy(JwtHelper.getUserId(token,audience.getBase64Secret()));
        return this.shopAdminService.updateSelectiveById(shopAdmin);
    }

    /**
     * 根据adminId删除系统用户信息
     * @param adminId
     * @return
     */
    @GetMapping("/remove")
    public ServerResponse remove(Integer adminId){
        return this.shopAdminService.deleteById(adminId);
    }

    /**
     * 批量删除
     * @param adminIds
     * @return
     */
    @GetMapping("/removeBatch")
    public ServerResponse removeBatch(String[] adminIds){
            return this.shopAdminService.deleteByIds(adminIds);

    }

    /**
     * 检查用户是否存在
     * @return
     */
    @GetMapping("/checkExists")
    public ServerResponse checkExists(String adminName){
        return this.shopAdminService.checkAdminNameExists(adminName);
    }
}
