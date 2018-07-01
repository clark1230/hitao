package com.hzitxx.hitao.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.permission.IShopAdminService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 账号控制器
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired(required = false)
    private IShopAdminService shopAdminService;



    /**
     * 处理登陆请求
     * @return
     */
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
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token",JwtTokenUtil.sign(shopAdmin2.getAdminName(),shopAdmin2.getAdminId()+"",
                        shopAdmin2.getAdminPassword()));
                shopAdmin2.setAdminPassword(null);
                jsonObject.put("shopAdmin",shopAdmin2);
                return  ServerResponse.createBySuccess(jsonObject);
            }
        }
    }

    /**
     * 系统注销
     * @return
//     */
    @PostMapping("/logout")
    public ServerResponse logout(){
        return ServerResponse.createBySuccessMessage("注销成功!");
    }
}
