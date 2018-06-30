package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.mapper.GatewayApiDefineMapper;
import com.hzitxx.hitao.service.GatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GatewayApiDefineServiceImpl implements GatewayApiDefineService {

    @Autowired(required = false)
    private GatewayApiDefineMapper gatewayApiDefineMapper;

    @Override
    public List<GatewayApiDefine> searchGatewayApiDefine(Map<String, Object> paramsMap) {
        return this.gatewayApiDefineMapper.searchGatewayApiDefine(paramsMap);
    }
}
