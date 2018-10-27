package com.hzitxx.hitao.mapper.order;


import com.hzitxx.hitao.system.pojo.order.ShopOrder;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-10-19
 */
public interface ShopOrderMapper{

    int addShopOrder(ShopOrder shopOrder);

    int addShopOrderSelective(ShopOrder shopOrder);

    int deleteById(int orderId);
                                                                                                
    int deleteByIds(String[] ids);

    int updateById(ShopOrder shopOrder);

    int updateSelectiveById(ShopOrder shopOrder);

    ShopOrder findOne(Integer orderId);
                                                                                                
    List<ShopOrder> searchShopOrder(Map<String, Object> map);
}