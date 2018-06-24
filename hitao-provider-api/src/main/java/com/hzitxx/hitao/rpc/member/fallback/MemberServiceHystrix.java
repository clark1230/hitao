package com.hzitxx.hitao.rpc.member.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.rpc.member.MemberService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class MemberServiceHystrix implements MemberService {


    @Override
    public ServerResponse register(ShopMember shopMember) {
        return ServerResponse.createByErrorCodeMessage(1,"会员服务调用失败!");
    }

    @Override
    public ServerResponse login(@RequestBody ShopMember shopMember) {
        return ServerResponse.createByErrorMessage("会员服务调用失败!");
    }

    @Override
    public ServerResponse saveMemberInfo(ShopMember shopMember) {
        return ServerResponse.createByErrorMessage("会员服务调用失败!");
    }

}
