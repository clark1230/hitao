package com.hzitxx.hitao.controller.authentication;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.AccountService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆控制器
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;

    @PostMapping("/login")
    public ServerResponse login(@RequestBody ShopAdmin shopAdmin){
        return  accountService.login(shopAdmin);
    }
}
