package com.hzitxx.hitao.controller.member;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.member.IShopMemberService;
import com.hzitxx.hitao.system.pojo.member.ShopMember;
import com.hzitxx.hitao.util.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
@Api(value = "会员Controller",tags = "{会员管理接口}")
@RestController
@RequestMapping("/shopMember")
public class ShopMemberController  {

    @Autowired
    private IShopMemberService shopMemberService;

    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "获取会员分页数据",notes = "showData")
    @GetMapping(value="shopMemberAjax")
    @ResponseBody
    public ServerResponse<LayuiEntity<ShopMember>> shopMemberAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                                  @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                                                  String memberName){
        Map<String,Object>  map = new HashMap<>();
        if(!StringUtils.isEmpty(memberName)){
            map.put("memberName",memberName);
        }
        return shopMemberService.page(page,limit,map);
    }



    /**
     * 处理添加表单
     * @param
     * @return
     */
   /* @PostMapping(value = "save")
    public ServerResponse save(ShopMember shopMember){
        return shopMemberService.addShopMemberSelective(shopMember);
    }*/

    /**
     * 根据系统用户编号获取系统用户信息
     * @param memberId
     * @return
     */
    /*@GetMapping("/findOne")
    public ServerResponse findOne(Integer memberId){
            return this.shopMemberService.findOne(memberId);
    }*/


    /**
     * 处理修改数据表单提交
     * @return
     */
   /* @PostMapping("/update")
    public ServerResponse update(ShopMember shopMember){
        return shopMemberService.updateSelectiveById(shopMember);
    }*/

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @ApiOperation(value = "批量删除会员信息",notes = "removeBatch")
    @GetMapping("removeBatch")
    public ServerResponse removeBatch(String[] ids){
       return shopMemberService.deleteByIds(ids);
    }

    /**
     * 删除会员
     * @param shopMember
     * @return
     */
    @ApiOperation(value = "删除会员信息",notes = "findShopArea",tags = "逻辑删除会员信息")
    @GetMapping("/remove")
    public ServerResponse remove(ShopMember shopMember){
        return shopMemberService.updateSelectiveById(shopMember);
    }
}
