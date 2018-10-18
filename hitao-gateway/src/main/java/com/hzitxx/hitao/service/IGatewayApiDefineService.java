package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-07
 */

public interface IGatewayApiDefineService {

    ServerResponse<List<GatewayApiDefine>> searchGatewayApiDefine(Map<String, Object> map);

}
