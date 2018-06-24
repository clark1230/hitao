package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.ShopArea;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地区表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-26
 */
public interface ShopAreaMapper{
                                
    List<ShopArea> searchShopArea(@Param("map") Map<String, Object> map);
}