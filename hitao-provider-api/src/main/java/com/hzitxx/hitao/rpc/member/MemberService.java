package com.hzitxx.hitao.rpc.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.rpc.member.fallback.MemberServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@FeignClient(name = "user-service",fallback = MemberServiceHystrix.class)
public interface MemberService {
    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ServerResponse register(@RequestBody  ShopMember shopMember);

    /**
     * 用户登陆
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ServerResponse login(@RequestBody ShopMember shopMember);

    /**
     * 编辑用户信息
     * @return
     */
    @RequestMapping(value = "/saveMemberInfo",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ServerResponse saveMemberInfo(@RequestBody ShopMember shopMember);

}
