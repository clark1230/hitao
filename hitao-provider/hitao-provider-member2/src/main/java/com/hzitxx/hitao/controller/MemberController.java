package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.service.IShopMemberService;
import com.hzitxx.hitao.utils.Md5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Api(value = "会员Controller",tags = "会员接口")
@RestController
public class MemberController {

    @Autowired
    private IShopMemberService memberService;

    /**
     * 用户登陆
     * @return
     */
   /* @ApiOperation(value = "用户登陆",notes = "用户登陆")
    @ApiImplicitParam(name="shopMember",value = "会员实体",required = true,dataType = "ShopMember")*/
    @PostMapping("/login")
    public ServerResponse login(@RequestBody  ShopMember shopMember) throws Exception {
        shopMember.setMemberPassword(Md5Util.getMD5(shopMember.getMemberPassword()));
        return this.memberService.login(shopMember);
    }

    /**
     * 用户注册
     * @return
     */
    /*@ApiOperation(value="用户注册",notes = "用户注册")
    @ApiImplicitParam(name="shopMember",value = "会员实体",required = true,dataType = "ShopMember")*/
    @PostMapping("/register")
    public ServerResponse register(@RequestBody  ShopMember shopMember) throws Exception {
        shopMember.setMemberPassword(Md5Util.getMD5(shopMember.getMemberPassword()));
        return this.memberService.addShopMemberSelective(shopMember);
    }
    /**
     * 检查用户是否存在!
     * @param memberId
     * @return
     */
    /*@ApiOperation(value = "检查用户是否存在",notes = "检查用户是否存在!")
    @ApiImplicitParam(name = "memberId",value = "会员编号",required = true,paramType = "query",dataType = "int")*/
    @GetMapping("/checkUserExists")
    public ServerResponse checkUseExists(@RequestParam("memberId") int memberId){
        return this.memberService.findOne(memberId);
    }

    /**
     * 编辑会员信息
     * @param shopMember
     * @return
     */
    @PostMapping("/saveMemberInfo")
    public ServerResponse<String> saveMemberInfo(@RequestBody ShopMember shopMember){
        return  this.memberService.updateSelectiveById(shopMember);
    }
}
