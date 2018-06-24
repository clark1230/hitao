
package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.ShopMenuVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台菜单表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */

public interface IShopMenuService  {

    int addShopMenu(ShopMenu shopMenu);

    ServerResponse addShopMenuSelective(ShopMenu obj);

    ServerResponse deleteById(int mId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopMenu shopMenu);

    ServerResponse updateSelectiveById(ShopMenu shopMenu);

   // List<ShopMenu> searchShopMenu(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopMenuVO>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer mId);

    ServerResponse menuData();

}
