package com.hzitxx.hitao.rpc;

import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import com.hzitxx.hitao.utils.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("system-service")
public interface GatewayApiDefineService {
    /**
     * 获取网关信息
     * @param enabled
     * @return
     */
    @RequestMapping(value = "/gatewayApiDefine/searchGatewayApi",method = RequestMethod.GET)
    ServerResponse<List<GatewayApiDefine>> searchGatewayApiDefine(@RequestParam("enabled") Integer enabled);
}
