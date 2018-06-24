package com.hzitxx.hitao.rpc.authentication.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.authentication.AccountService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceFallback implements AccountService {

    @Override
    public ServerResponse login(ShopAdmin shopAdmin) {
        return ServerResponse.createByErrorMessage("后台系统登陆接口调用失败!");
    }
}
