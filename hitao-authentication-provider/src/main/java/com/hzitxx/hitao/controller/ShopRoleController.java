package com.hzitxx.hitao.controller;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.service.IShopRoleService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.AdminRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value="shopRoleAjax")
    public LayuiEntity<AdminRoleVO> shopRoleAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                 @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        LayuiEntity<AdminRoleVO> layuiEntity = shopRoleService.page(page,limit,map);
        return layuiEntity;
    }

    /**
     * 添加角色信息
     * @return
     */
    @PostMapping("addShopRole")
    public Object addShopRole(@RequestBody ShopRole shopRole,
                              @RequestHeader("token") String token){
        shopRole.setCreatedBy(JwtHelper.getUserId(token,
                audience.getBase64Secret()));
        shopRole.setCreatedTime(new Date());
        return this.shopRoleService.addShopRole(shopRole);
    }

    /**
     * 根据角色id查询角色信息
     * @param roleId
     * @return
     */
    @GetMapping("findOne")
    public Object findOne(@RequestParam("roleId") Integer roleId){
        return this.shopRoleService.findOne(roleId);
    }

    /**
     * 修改角色
     * @param shopRole
     * @return
     */
    @PostMapping("updateShopRole")
    public Object updateShopRole(@RequestBody ShopRole shopRole,
                                 @RequestHeader("token")String token){

        shopRole.setUpdatedBy(JwtHelper.getUserId(token,
                audience.getBase64Secret()));
        shopRole.setUpdatedTime(new Date());
        return this.shopRoleService.updateSelectiveById(shopRole);
    }

    /**
     * 异步删除删除
     * @param roleId 角色编号
     * @return 操作结果
     */
    @GetMapping(value = "/remove")
    public ServerResponse remove(@RequestParam("roleId")int roleId){
        return this.shopRoleService.deleteById(roleId);
    }

    /**
     * 批量删除角色信息
     * @return
     */
    @GetMapping(value = "/removeBatch")
    public ServerResponse removeBatch(@RequestParam("ids")String ids){
        String[] idsArr = ids.split(",");
        return this.shopRoleService.deleteByIds(idsArr);
    }
}
