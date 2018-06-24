package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.service.IShopMenuService;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.ShopMenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "系统菜单Controller",tags = "系统菜单控制器")
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
    @ApiOperation(value = "获取菜单数据",notes = "获取菜单数据")
    @GetMapping("/menuData")
    public Object menuData(){
        return shopMenuService.menuData();
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询菜单信息",notes = "根据id查询菜单信息")
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
    public ServerResponse<LayuiEntity<ShopMenuVO>> shopMenuData(@RequestParam(value = "page",defaultValue = "1")int page,
                                                @RequestParam(value = "limit",defaultValue = "20")int limit){
        return this.shopMenuService.page(page,limit,null);
    }

    /**
     * 保存权限信息
     * @param shopMenu
     * @return
     */
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
    @GetMapping("/remove")
    public ServerResponse remove(Integer id){
        return this.shopMenuService.deleteById(id);
    }

    /**
     * 批量删除系统权限
     * @param ids
     * @return
     */
    @GetMapping("/removeBatch")
    public ServerResponse removeBatch(String[] ids){
        return this.shopMenuService.deleteByIds(ids);
    }
}
