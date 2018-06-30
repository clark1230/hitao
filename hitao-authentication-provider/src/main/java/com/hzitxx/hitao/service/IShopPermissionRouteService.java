package com.hzitxx.hitao.service;

import com.hzitxx.hitao.system.pojo.permission.ShopPermissionRoute;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-21
 */

public interface IShopPermissionRouteService  {

    int addShopPermissionRoute(ShopPermissionRoute shopPermissionRoute);

    int addShopPermissionRouteSelective(ShopPermissionRoute obj);

    int deleteById(int routeId);

    int deleteByIds(String[] ids);

    int updateById(ShopPermissionRoute shopPermissionRoute);

    int updateSelectiveById(ShopPermissionRoute shopPermissionRoute);

    ServerResponse<List<ShopPermissionRoute>> searchShopPermissionRoute(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    LayuiEntity<ShopPermissionRoute> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ShopPermissionRoute findOne(Integer routeId);

    /**
     * 获取菜单信息
     * @return
     */
    ServerResponse menuTree();

}
