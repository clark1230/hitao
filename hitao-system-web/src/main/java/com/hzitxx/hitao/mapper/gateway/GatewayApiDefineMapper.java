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
public interface GatewayApiDefineMapper{

    int addGatewayApiDefine(GatewayApiDefine obj);

    int addGatewayApiDefineSelective(GatewayApiDefine obj);

    int deleteById(int id);
                                
    int deleteByIds(String[] ids);

    int updateById(GatewayApiDefine gatewayApiDefine);

    int updateSelectiveById(GatewayApiDefine gatewayApiDefine);

    GatewayApiDefine findOne(Integer id);
                                
    List<GatewayApiDefine> searchGatewayApiDefine(@Param("map") Map<String, Object> map);
}