package com.hzitxx.hitao.rpc.member.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.member.ShopAreaService;
import org.springframework.stereotype.Component;

@Component
public class ShopAreaServiceFallback  implements ShopAreaService {
    @Override
    public ServerResponse getShopArea(int parentId) {
        return null;
    }
}
