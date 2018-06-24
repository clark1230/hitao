package com.hzitxx.hitao.service.gateway;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import com.hzitxx.hitao.util.LayuiEntity;

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

public interface IGatewayApiDefineService  {

    ServerResponse addGatewayApiDefine(GatewayApiDefine gatewayApiDefine);

    ServerResponse addGatewayApiDefineSelective(GatewayApiDefine obj);

    ServerResponse deleteById(int id);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GatewayApiDefine gatewayApiDefine);

    ServerResponse updateSelectiveById(GatewayApiDefine gatewayApiDefine);

    ServerResponse<List<GatewayApiDefine>> searchGatewayApiDefine(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GatewayApiDefine>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer id);

}
