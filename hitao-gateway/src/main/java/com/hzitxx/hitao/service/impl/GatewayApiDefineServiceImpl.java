package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.gateway.GatewayApiDefineMapper;
import com.hzitxx.hitao.service.IGatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-07
 */
@Service
public class GatewayApiDefineServiceImpl implements IGatewayApiDefineService {

    @Autowired(required = false)
    private GatewayApiDefineMapper mapper;


    @Override
    public  ServerResponse<List<GatewayApiDefine>> searchGatewayApiDefine(Map<String, Object> map){
        List<GatewayApiDefine> gatewayApiDefines = this.mapper.searchGatewayApiDefine(map);
        if(gatewayApiDefines.size() == 0){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(gatewayApiDefines);
    }
}

