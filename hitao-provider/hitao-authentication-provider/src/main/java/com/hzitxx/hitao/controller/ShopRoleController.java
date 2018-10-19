package com.hzitxx.hitao.controller;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.service.IShopRoleService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.AdminRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台后台角色 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
@Api(value = "角色Controller",tags = "{系统角色接口}")
@RestController
@RequestMapping("/shopRole")
public class ShopRoleController  {
    @Autowired
    private IShopRoleService shopRoleService;

    @Autowired
    private Audience audience;

    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "获取角色分页数据",tags = "showData", notes = "获取权限树状数据")
    @GetMapping(value="showData")
    public ServerResponse<LayuiEntity<AdminRoleVO>> showData(@RequestParam(value = "page",defaultValue = "1") int page,
                                                 @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                                             String roleName){
        Map<String,Object>  map = new HashMap<>();
        if(!StringUtils.isEmpty(roleName)){
            map.put("roleName",roleName);
        }
        return shopRoleService.page(page,limit,map);
    }

    /**
     * 获取全部角色信息
     * @return
     */
    @ApiOperation(value="获取全部角色信息",tags = "findAll",notes = "获取(【逻辑删除】)全部角色信息,主要用在为用户授予角色操作上")
    @GetMapping("/findAll")
    public ServerResponse<List<ShopRole>> findAll(@RequestParam(value = "isDel",defaultValue = "0") Integer isDel){
        return this.shopRoleService.searchShopRole(new HashMap<String,Object>(){{
            put("isDel",isDel);
        }});
    }

    /**
     * 添加角色信息
     * @return
     */
    @ApiOperation(value = "保存角色信息",tags = "save", notes = "保存角色信息")
    @PostMapping("save")
    public Object save(@RequestBody ShopRole shopRole,
                              @RequestHeader("token") String token){
        shopRole.setCreatedBy(JwtHelper.getUserId(token,
                audience.getBase64Secret()));
        shopRole.setCreatedTime(new Date());
        return this.shopRoleService.addShopRoleSelective(shopRole);
    }

    /**
     * 根据角色id查询角色信息
     * @param roleId
     * @return
     */
    @ApiOperation(value = "获取角色信息",tags = "findOne", notes = "根据角色编号获取角色信息")
    @GetMapping("findOne")
    public Object findOne(@RequestParam("roleId") Integer roleId){
        return this.shopRoleService.findOne(roleId);
    }

    /**
     * 修改角色
     * @param shopRole
     * @return
     */
    @ApiOperation(value = "编辑角色信息",tags = "update", notes = "编辑角色信息")
    @PostMapping("update")
    public Object update(@RequestBody ShopRole shopRole,
                                 @RequestHeader("token")String token){

        shopRole.setUpdatedBy(JwtHelper.getUserId(token,
                audience.getBase64Secret()));
        shopRole.setUpdatedTime(new Date());
        return this.shopRoleService.updateSelectiveById(shopRole);
    }

    /**
     * 删除角色信息
     * @param roleId 角色编号
     * @return 操作结果
     */
    @ApiOperation(value = "删除角色信息",tags = "remove", notes = "物理删除角色信息")
    @GetMapping(value = "/remove")
    public ServerResponse remove(@RequestParam("roleId")int roleId){
        return this.shopRoleService.deleteById(roleId);
    }

    /**
     * 批量删除角色信息
     * @return
     */
    @ApiOperation(value = "批量删除角色信息",tags = "removeBatch", notes = "物理批量删除角色信息")
    @GetMapping(value = "/removeBatch")
    public ServerResponse removeBatch(@RequestParam("ids")String ids){
        String[] idsArr = ids.split(",");
        return this.shopRoleService.deleteByIds(idsArr);
    }

    /**
     * 角色授权
     * @param roleId
     * @param permissionIds
     * @return
     */
    @ApiOperation(value = "角色授权",tags = "grantPermission", notes = "角色授权")
    @GetMapping("/grantPermission")
    public ServerResponse<String> grantPermission(@RequestParam("roleId") Integer roleId,
                                                  @RequestParam("permissionIds") Integer[] permissionIds){
        return this.shopRoleService.grantPermssion(roleId,permissionIds);
    }


}
