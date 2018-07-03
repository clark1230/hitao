package com.hzitxx.hitao.rpc.member;

import com.hzitxx.hitao.commons.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface ShopAreaService {
    /**
     * 获取省市区信息
     * @param parentId
     * @return
     */
    @RequestMapping("/shopArea/getShopArea")
    ServerResponse getShopArea(@RequestParam(value = "parentId", defaultValue = "0") int parentId);
}
