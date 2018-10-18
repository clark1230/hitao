package com.hzitxx.hitao.service.permission;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.util.LayuiEntity;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-15
 */

public interface IShopAdminService  {

    ServerResponse addShopAdmin(ShopAdmin shopAdmin);

    ServerResponse addShopAdminSelective(ShopAdmin obj);

    ServerResponse deleteById(int adminId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopAdmin shopAdmin);

    ServerResponse updateSelectiveById(ShopAdmin shopAdmin);

    ServerResponse searchShopAdmin(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopAdmin>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer adminId);

    /**
     * 根据编号查询数据
     * @param adminId
     * @return
     */
    ShopAdmin findById(Serializable adminId);

    /**
     * 处理登陆
     * @param shopAdmin
     * @return
     */
    ShopAdmin login(ShopAdmin shopAdmin);

    /**
     * 处理登陆
     * @param adminName
     * @return
     */
    ShopAdmin login(String adminName);
}
