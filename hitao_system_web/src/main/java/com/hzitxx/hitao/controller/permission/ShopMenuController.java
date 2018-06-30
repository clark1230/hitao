package com.hzitxx.hitao.controller.permission;

import com.hzitxx.hitao.service.permission.IShopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@Api(value = "系统菜单Controller",tags = "系统菜单控制器")
@RestController
@RequestMapping("/shopMenu")
public class ShopMenuController {

    @Autowired
    private IShopMenuService shopMenuService;
//    @ApiOperation(value = "获取菜单数据",notes = "获取菜单数据")
    @GetMapping("/menuData")
    public Object menuData(){
        return shopMenuService.menuData();
    }

    /**
     * 根据mId查询数据
     * @param mId
     * @return
     */
//    @ApiOperation(value = "根据mId查询菜单信息",notes = "根据mId查询菜单信息")
    @GetMapping("/findOne")
    public Object findOne(@RequestParam("mId") int mId){
        return  this.shopMenuService.findOne(mId);
    }
}
