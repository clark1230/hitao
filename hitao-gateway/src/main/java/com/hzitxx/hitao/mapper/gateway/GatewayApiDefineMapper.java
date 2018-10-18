package com.hzitxx.hitao.mapper.gateway;


import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-07
 */
public interface GatewayApiDefineMapper {

    List<GatewayApiDefine> searchGatewayApiDefine(@Param("map") Map<String, Object> map);
}