package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.AdminRoleVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台后台角色 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */

public interface IShopRoleService  {

    ServerResponse addShopRole(ShopRole shopRole);

    ServerResponse addShopRoleSelective(ShopRole obj);

    ServerResponse deleteById(int roleId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopRole shopRole);

    ServerResponse updateSelectiveById(ShopRole shopRole);

    List<ShopRole> searchShopRole(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    LayuiEntity<AdminRoleVO> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer roleId);

}
