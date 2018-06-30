package com.hzitxx.hitao.service.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.member.ShopAddress;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.Map;

/**
 * <p>
 * 买家地址信息表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
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
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    LayuiEntity<ShopAddress> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer id);

}
