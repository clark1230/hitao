package com.hzitxx.hitao.mapper.member;


import com.hzitxx.hitao.system.pojo.member.ShopAddress;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家地址信息表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
public interface ShopAddressMapper{

    int addShopAddress(ShopAddress obj);

    int addShopAddressSelective(ShopAddress obj);

    int deleteById(int id);
                                            
    int deleteByIds(String[] ids);

    int updateById(ShopAddress shopAddress);

    int updateSelectiveById(ShopAddress shopAddress);

    ShopAddress findOne(Integer id);
                                            
    List<ShopAddress> searchShopAddress(@Param("map") Map<String, Object> map);
}