package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.rpc.GatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import com.hzitxx.hitao.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired(required = false)
    private GatewayApiDefineService gatewayApiDefineService;
    @GetMapping("/test1230")
    public ServerResponse<List<GatewayApiDefine>> gatewayApi(){
        return gatewayApiDefineService.searchGatewayApiDefine(1);
    }
}
