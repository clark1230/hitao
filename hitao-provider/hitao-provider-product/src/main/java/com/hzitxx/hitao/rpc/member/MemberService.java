package com.hzitxx.hitao.rpc.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.rpc.member.fallback.MemberSeriviceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service",fallback = MemberSeriviceHystrix.class)
public interface MemberService {
    /**
     * 检查用户是否存在
     * @param memberId
     * @return
     */
    @RequestMapping(value = "checkUserExists",method = RequestMethod.GET)
    ServerResponse<ShopMember> checkUserExists(@RequestParam("memberId")int memberId);

}
