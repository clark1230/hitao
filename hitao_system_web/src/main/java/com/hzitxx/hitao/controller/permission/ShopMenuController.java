package com.hzitxx.hitao.controller.permission;

import com.hzitxx.hitao.service.permission.IShopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/shopMenu")
public class ShopMenuController {

    @Autowired
    private IShopMenuService shopMenuService;
    @GetMapping("/menuData")
    public Object menuData(){
        return shopMenuService.menuData();
    }

    /**
     * 根据mId查询数据
     * @param mId
     * @return
     */
    @GetMapping("/findOne")
    public Object findOne(@RequestParam("mId") int mId){
        return  this.shopMenuService.findOne(mId);
    }
}
