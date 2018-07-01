package com.hzitxx.hitao.rpc.product;

import com.hzitxx.hitao.rpc.product.fallback.ShopFrontCategoryHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 代理商品微服务
 */
@FeignClient(name = "product-service",fallback = ShopFrontCategoryHystrix.class)
public interface ShopFrontCategoryService{
    /**
     * 获取类目信息
     * @return
     */
    @RequestMapping(value = "/frontCate",method = RequestMethod.GET,produces = "application/json")
    Object searchShopFrontCategory();

    /**
     * 获取当前类目
     * @param frontCatId
     * @return
     */
    @RequestMapping(value = "/currentCate",method = RequestMethod.GET,produces = "application/json")
    Object currentCate(@RequestParam("frontCatId")Integer frontCatId);

}
