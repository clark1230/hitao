package com.hzitxx.hitao.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.service.IShopAdminService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 账号控制器
 */
@RestController
@RequestMapping("/account")
@Api(value = "账号Controller",tags = "账号控制器")
public class AccountController {

    @Autowired(required = false)
    private IShopAdminService shopAdminService;

    @Autowired
    private Audience audience;

    /**
     * 处理登陆请求
     * @return
     */
    @ApiOperation(value = "系统登陆",notes = "系统登陆")
    @ApiImplicitParam(name="shopAdmin",value = "管理员实体",required = true,dataType = "ShopAdmin")
    @PostMapping("/login")
    public ServerResponse login(@Validated @RequestBody ShopAdmin shopAdmin,
                                BindingResult bindingResult){
        ShopAdmin shopAdmin2 = this.shopAdminService.login(shopAdmin.getAdminName());
        if(shopAdmin2 == null){
            return ServerResponse.createByErrorMessage("用户名或者密码错误!");
        }else{
            if(!shopAdmin2.getAdminPassword().equals(shopAdmin.getAdminPassword())){
               return ServerResponse.createByErrorMessage("用户名或者密码错误!");
            }else{
                String jwtToken = JwtHelper.createJWT(shopAdmin2.getAdminName(),
                        shopAdmin2.getAdminId()+"",
                        "member",//暂时写死
                        audience.getClientId(),
                        audience.getName(),
                        audience.getExpiresSecond()*1000,//1000不能省略
                        audience.getBase64Secret());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token",jwtToken);
                shopAdmin2.setAdminPassword(null);
                jsonObject.put("shopAdmin",shopAdmin2);
                return  ServerResponse.createBySuccess(jsonObject);
            }
        }
    }

    /**
     * 系统注销
     * @return
     */
    @GetMapping("/logout")
    public ServerResponse logout(@RequestHeader("token")String token){
        return this.shopAdminService.logout(JwtHelper.getUserId(token,audience.getBase64Secret()));
    }
}
