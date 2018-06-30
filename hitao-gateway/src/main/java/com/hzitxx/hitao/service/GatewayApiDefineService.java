package com.hzitxx.hitao.service;

import com.hzitxx.hitao.system.pojo.GatewayApiDefine;

import java.util.List;
import  java.util.Map;

public interface GatewayApiDefineService {
    public List<GatewayApiDefine> searchGatewayApiDefine(Map<String, Object> paramsMap);
}
