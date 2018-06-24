package com.hzitxx.hitao.controller.memeber;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.rpc.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 处理会员注册请求
     * @param
     * @return
     */
    @PostMapping(value = "/register")
    public ServerResponse register(@RequestBody ShopMember shopMember){
        System.out.println(shopMember);
        return memberService.register(shopMember);
    }

    /**
     * 处理用户登陆
     * @param
     * @return
     */
    @PostMapping(value = "/login")
    public ServerResponse login(@RequestBody ShopMember shopMember){
        return memberService.login(shopMember);
    }

    /**
     * 处理编辑会员信息请求
     * @param shopMember
     * @return
     */
    @PostMapping(value = "/saveMemberInfo")
    public ServerResponse saveMemberInfo(@RequestBody ShopMember shopMember){
        return this.memberService.saveMemberInfo(shopMember);
    }
}
