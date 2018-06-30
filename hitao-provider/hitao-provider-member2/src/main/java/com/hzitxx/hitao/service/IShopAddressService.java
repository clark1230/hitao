package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.member.ShopAddress;
import com.hzitxx.hitao.front.member.ShopAddress;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家地址信息表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-04
 */

public interface IShopAddressService  {

    ServerResponse addShopAddress(ShopAddress shopAddress);

    ServerResponse addShopAddressSelective(ShopAddress obj);

    ServerResponse deleteById(int id);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopAddress shopAddress);

    ServerResponse updateSelectiveById(ShopAddress shopAddress);

    ServerResponse searchShopAddress(Map<String, Object> map);



    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer id);

    /**
     * 获取会员的默认收货地址
     * @param memberId
     * @return
     */
    ServerResponse searchDefaultAddress(Integer memberId);

}
