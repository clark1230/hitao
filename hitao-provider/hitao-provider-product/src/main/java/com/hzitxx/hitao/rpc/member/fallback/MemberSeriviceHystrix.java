package com.hzitxx.hitao.rpc.member.fallback;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.rpc.member.MemberService;
import org.springframework.stereotype.Component;

@Component
public class MemberSeriviceHystrix implements MemberService {

    @Override
    public ServerResponse<ShopMember> checkUserExists(int memberId) {
        return ServerResponse.createByErrorMessage("服务调用失败!");
    }
}
