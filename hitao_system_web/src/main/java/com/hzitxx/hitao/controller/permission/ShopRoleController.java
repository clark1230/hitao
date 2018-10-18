package com.hzitxx.hitao.controller.permission;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hzitxx.hitao.service.permission.IShopRoleService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 平台后台角色 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
//@Api(value = "系统角色Controller",tags = "系统角色控制器")
@RestController
@RequestMapping("/shopRole")
public class ShopRoleController  {
    @Autowired
    private IShopRoleService shopRoleService;

    /**
     * 分页
     * @return
     */
//    @ApiOperation(value = "获取角色信息",notes = "获取角色信息")
    @GetMapping(value="shopRoleAjax")
    public ServerResponse<LayuiEntity<ShopRole>> shopRoleAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        return shopRoleService.page(page,limit,map);
    }

    /**
     * 添加角色信息
     * @return
     */
//    @ApiOperation(value = "添加角色信息",tags = "添加角色信息")
    @PostMapping("addShopRole")
    public Object addShopRole(@RequestBody ShopRole shopRole){
        shopRole.setCreatedTime(new Date());
        return this.shopRoleService.addShopRole(shopRole);
    }

    /**
     * 根据角色id查询角色信息
     * @param roleId
     * @return
     */
//    @ApiOperation(value = "根据roleId获取角色信息",notes = "根据roleId获取角色信息")
    @GetMapping("findOne")
    public Object findOne(@RequestParam("roleId") Integer roleId){
        return this.shopRoleService.findOne(roleId);
    }

    /**
     * 修改角色
     * @param shopRole
     * @return
     */
//    @ApiOperation(value = "编辑角色信息",notes = "编辑角色信息")
    @PostMapping("updateShopRole")
    public Object updateShopRole(@RequestBody ShopRole shopRole){
        shopRole.setUpdatedTime(new Date());
        return this.shopRoleService.updateSelectiveById(shopRole);
    }

    /**
     * 异步删除删除
     * @param roleId 角色编号
     * @return 操作结果
     */
//    @ApiOperation(value = "删除角色信息",notes = "删除角色信息")
    @GetMapping(value = "deleteRole")
    public Object shopRoleDelete(@RequestParam("roleId")int roleId){
        System.out.println("删除数据!");
        return this.shopRoleService.deleteById(roleId);
    }

    /**
     * 批量删除角色信息
     * @return
     */
//    @ApiOperation(value = "批量删除角色信息",notes = "批量删除角色信息")
    @GetMapping(value = "deleteShopRoleByIds")
    public Object deleteShopRoleByIds(@RequestParam("ids")String ids){
        String[] idsArr = ids.split(",");

        return this.shopRoleService.deleteByIds(idsArr);
    }
}
