package com.hzitxx.hitao.rpc.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.ShopCartService;
import org.springframework.stereotype.Component;

@Component
public class ShopCartServiceHystrix implements ShopCartService {

    @Override
    public ServerResponse cartCount(Integer memberId) {
        return ServerResponse.createByErrorMessage("产品微服务调用失败!");
    }
}
