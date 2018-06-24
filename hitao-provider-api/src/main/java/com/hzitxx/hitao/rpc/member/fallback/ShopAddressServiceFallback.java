package com.hzitxx.hitao.rpc.member.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.member.ShopAddress;
import com.hzitxx.hitao.rpc.member.ShopAddressService;
import org.springframework.stereotype.Component;

@Component
public class ShopAddressServiceFallback  implements ShopAddressService {
    @Override
    public ServerResponse addShopAddress(ShopAddress shopAddress) {
        return null;
    }

    @Override
    public ServerResponse list(int memberId) {
        return null;
    }

    @Override
    public ServerResponse delete(int id) {
        return null;
    }

    @Override
    public ServerResponse detail(int id) {
        return null;
    }

    @Override
    public ServerResponse updateShopAddress(ShopAddress shopAddress) {
        return null;
    }

    @Override
    public ServerResponse getDefaultAddres() {
        return ServerResponse.createByErrorMessage("会员微服务调用失败!");
    }
}
