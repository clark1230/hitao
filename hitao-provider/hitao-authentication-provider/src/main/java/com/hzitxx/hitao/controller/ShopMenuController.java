package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.service.IShopMenuService;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "权限Controller",tags = "{系统权限接口}")
@RestController
@RequestMapping("/shopMenu")
public class ShopMenuController {

    @Autowired
    private IShopMenuService shopMenuService;

    @Autowired
    private Audience audience;

    /**
     * 获取菜单信息
     * @return
     */
    @ApiOperation(value = "获取权限树状数据",tags = "menuTreeData", notes = "获取权限树状数据")
    @GetMapping("/menuTreeData")
    public Object menuData(){
        return shopMenuService.menuData();
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @ApiOperation(value = "获取权限信息",tags = "findOne", notes = "根据权限编号获取权限信息")
    @GetMapping("/findOne")
    public Object findOne(@RequestParam("id") Integer id){
        return  this.shopMenuService.findOne(id);
    }

    /**
     * 获取菜单数据
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/shopMenuData")
    public ServerResponse<LayuiEntity<ShopMenu>> shopMenuData(@RequestParam(value = "page",defaultValue = "1")int page,
                                                @RequestParam(value = "limit",defaultValue = "20")int limit){
        return this.shopMenuService.page(page,limit,null);
    }

    /**
     * 保存权限信息
     * @param shopMenu
     * @return
     */
    @ApiOperation(value = "保存权限信息",tags = "save", notes = "保存权限信息")
    @PostMapping("/save")
    public ServerResponse save(@RequestBody ShopMenu shopMenu,
                               @RequestHeader("token")String token){
        shopMenu.setCreatedTime(new Date());
        shopMenu.setCreatedBy(JwtHelper.getUserId(token,audience.getBase64Secret()));
        return this.shopMenuService.addShopMenuSelective(shopMenu);
    }

    /**
     * 编辑权限信息
     * @param shopMenu
     * @param token
     * @return
     */
    @ApiOperation(value = "编辑权限信息",tags = "update", notes = "编辑权限信息")
    @PostMapping("/update")
    public ServerResponse update(@RequestBody ShopMenu shopMenu,
                                 @RequestHeader("token") String token){
        shopMenu.setUpdatedBy(JwtHelper.getUserId(token,audience.getBase64Secret()));
        shopMenu.setUpdatedTime(new Date());
        return this.shopMenuService.updateSelectiveById(shopMenu);
    }

    /**
     * 删除系统权限
     * @param id
     * @return
     */
    @ApiOperation(value = "删除权限信息",tags = "remove", notes = "物理删除权限信息")
    @GetMapping("/remove")
    public ServerResponse remove(Integer id){
        return this.shopMenuService.deleteById(id);
    }

    /**
     * 批量删除系统权限
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除权限信息",tags = "removeBatch", notes = "物理批量删除权限信息")
    @GetMapping("/removeBatch")
    public ServerResponse removeBatch(String[] ids){
        return this.shopMenuService.deleteByIds(ids);
    }
}
