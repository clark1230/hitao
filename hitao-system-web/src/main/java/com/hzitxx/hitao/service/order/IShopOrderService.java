package com.hzitxx.hitao.service.order;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.order.ShopOrder;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-10-19
 */

public interface IShopOrderService  {

    ServerResponse addShopOrder(ShopOrder shopOrder);

    ServerResponse addShopOrderSelective(ShopOrder obj);

    ServerResponse deleteById(int orderId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopOrder shopOrder);

    ServerResponse updateSelectiveById(ShopOrder shopOrder);

    ServerResponse<List<ShopOrder>> searchShopOrder(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopOrder>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ShopOrder> findOne(Integer orderId);

}
