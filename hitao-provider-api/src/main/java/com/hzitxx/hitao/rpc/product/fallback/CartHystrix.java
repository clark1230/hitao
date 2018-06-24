package com.hzitxx.hitao.rpc.product.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.product.CartService;
import org.springframework.stereotype.Component;

@Component
public class CartHystrix implements CartService {
    @Override
    public Object checkout(int goodsId, int number) {
        return "服务调用失败!";
    }

    @Override
    public Object add(int goodsId, int number,int memberId) {
        return ServerResponse.createByErrorMessage("服务调用失败!");
    }

    @Override
    public Object delete(int memberId, String goodsIds) {
        return ServerResponse.createByErrorMessage("服务调用失败!");
    }

    @Override
    public Object update(int goodsId, int number, int mbmerId) {
        return null;
    }

    @Override
    public Object cartList(int memberId) {
        return ServerResponse.createByErrorMessage("服务调用失败!");
    }

    @Override
    public Object cartCount(int memberId) {
        return null;
    }
}
