package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.service.IShopMemberService;
import com.hzitxx.hitao.utils.Md5Util;
import com.hzitxx.hitao.vo.shopmember.ShopMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopMemberController {

    @Autowired
    private IShopMemberService memberService;

    /**
     * 处理用户登陆
     * @return
     */
    @PostMapping("/login")
    public ServerResponse login(@RequestBody  ShopMember shopMember) throws Exception {
        shopMember.setMemberPassword(Md5Util.getMD5(shopMember.getMemberPassword()));
        return this.memberService.login(shopMember);
    }

    /**
     * 处理用户注册
     * @return
     */
    @PostMapping("/register")
    public ServerResponse register(@RequestBody ShopMemberVO shopMemberVO) throws Exception {
        return this.memberService.register(shopMemberVO);
    }

    /**
     * 检查用户是否存在!
     * @param memberId
     * @return
     */
    @GetMapping("/checkUserExists")
    public ServerResponse checkUseExists(@RequestParam("memberId") int memberId){
        return this.memberService.findOne(memberId);
    }

    /**
     * 会员注册发送验证码
     * @return
     */
    @GetMapping("/sendIdentifyingCode")
    public ServerResponse sendIdentifyingCode(@RequestParam("memberMobile") String memberMobile) throws Exception {
       return  this.memberService.sendIdentifyingCode(memberMobile);
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

    /**
     * 校验短信验证码
     * @param memberMobile 手机号码
     * @param code  验证码
     * @return
     */
    @GetMapping("/checkIdentifyingCode")
    public ServerResponse checkIdentifyingCode(@RequestParam("memberMobile")String memberMobile,
                                               @RequestParam("code") Integer code){
        return this.memberService.checkIdentifyingCode(memberMobile,code);
    }
}
