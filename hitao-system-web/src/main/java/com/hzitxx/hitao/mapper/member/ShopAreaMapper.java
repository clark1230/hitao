package com.hzitxx.hitao.mapper.member;


import com.hzitxx.hitao.system.pojo.member.ShopArea;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地区表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
public interface ShopAreaMapper{

    int addShopArea(ShopArea obj);

    int addShopAreaSelective(ShopArea obj);

    int deleteById(int areaId);
                                    
    int deleteByIds(String[] ids);

    int updateById(ShopArea shopArea);

    int updateSelectiveById(ShopArea shopArea);

    ShopArea findOne(Integer areaId);
                                    
    List<ShopArea> searchShopArea(@Param("map") Map<String, Object> map);
}