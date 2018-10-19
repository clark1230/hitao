package com.hzitxx.hitao.mapper.permission;


import com.hzitxx.hitao.system.pojo.permission.ShopRoleMenu;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色菜单表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
public interface ShopRoleMenuMapper{

    int addShopRoleMenu(ShopRoleMenu obj);

    int addShopRoleMenuSelective(ShopRoleMenu obj);

    int deleteById(int id);
            
    int deleteByIds(String[] ids);

    int deleteByRoleId(int roleId);

    int updateById(ShopRoleMenu shopRoleMenu);

    int updateSelectiveById(ShopRoleMenu shopRoleMenu);

    ShopRoleMenu findOne(Integer id);
            
    List<ShopRoleMenu> searchShopRoleMenu(Map<String, Object> map);
}