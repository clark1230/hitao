package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.front.member.ShopAddress;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家地址信息表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-04
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

    /**
     * 检查是否存在默认收货地址
     * @param memberId
     * @return
     */
    ShopAddress checkDefaultShopAddress(Integer memberId);

    /**
     * 获取会员的默认收货地址
     * @param memberId
     * @return
     */
    ShopAddress searchDefaulAddress(Integer memberId);
}