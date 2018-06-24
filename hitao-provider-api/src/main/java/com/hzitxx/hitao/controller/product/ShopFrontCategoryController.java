package com.hzitxx.hitao.controller.product;

import com.hzitxx.hitao.rpc.product.ShopFrontCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopFrontCategoryController {

    @Autowired
    private ShopFrontCategoryService frontCategoryService;

    /**
     * 获取类目信息
     * @return
     */
    @GetMapping(value = "/frontCate",produces = "application/json")
    public Object forntCate(){
        return frontCategoryService.searchShopFrontCategory();
    }

    /**
     * 获取当前类目
     * @param frontCatId
     * @return
     */
    @GetMapping(value = "/currentCate",produces = "application/json")
    public Object currentCate(@RequestParam("frontCatId")Integer frontCatId){
        return  this.frontCategoryService.currentCate(frontCatId);
    }
}
