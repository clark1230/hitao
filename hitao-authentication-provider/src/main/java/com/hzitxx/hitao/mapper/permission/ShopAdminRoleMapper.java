package com.hzitxx.hitao.mapper.permission;


import com.hzitxx.hitao.system.pojo.permission.ShopAdminRole;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
public interface ShopAdminRoleMapper{

    int addShopAdminRole(ShopAdminRole obj);

    int addShopAdminRoleSelective(ShopAdminRole obj);

    int deleteById(int id);
            
    int deleteByIds(String[] ids);

    int deleteByAdminId(Integer adminId);

    int updateById(ShopAdminRole shopAdminRole);

    int updateSelectiveById(ShopAdminRole shopAdminRole);

    ShopAdminRole findOne(Integer id);
            
    List<ShopAdminRole> searchShopAdminRole(Map<String, Object> map);
}