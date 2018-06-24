package com.hzitxx.hitao.rpc.product.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.product.ShopFrontCategoryService;
import org.springframework.stereotype.Component;

@Component
public class ShopFrontCategoryHystrix implements ShopFrontCategoryService {
    @Override
    public Object searchShopFrontCategory() {
        return ServerResponse.createByErrorMessage("服务调用失败!");
    }

    @Override
    public Object currentCate(Integer frontCatId) {
        return ServerResponse.createByErrorMessage("获取当前类目服务调用失败!");
    }
}
