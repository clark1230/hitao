package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopArea;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-26
 */

public interface IShopAreaService  {

    ServerResponse searchShopArea(Map<String,Object> map);

}
