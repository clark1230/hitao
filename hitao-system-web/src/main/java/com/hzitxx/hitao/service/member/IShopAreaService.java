package com.hzitxx.hitao.service.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.member.ShopArea;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.Map;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */

public interface IShopAreaService  {

    ServerResponse addShopArea(ShopArea shopArea);

    ServerResponse addShopAreaSelective(ShopArea obj);

    ServerResponse deleteById(int areaId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopArea shopArea);

    ServerResponse updateSelectiveById(ShopArea shopArea);

    ServerResponse searchShopArea(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopArea>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer areaId);

}
