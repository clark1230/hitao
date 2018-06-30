
package com.hzitxx.hitao.service.permission;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.util.LayuiEntity;

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

    int addShopMenuSelective(ShopMenu obj);

    int deleteById(int mId);

    int deleteByIds(String[] ids);

    int updateById(ShopMenu shopMenu);

    int updateSelectiveById(ShopMenu shopMenu);

    List<ShopMenu> searchShopMenu(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    LayuiEntity<ShopMenu> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer mId);

    ServerResponse menuData();

}
