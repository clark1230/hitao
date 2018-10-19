package com.hzitxx.hitao.mapper.permission;

import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.vo.AdminRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台后台角色 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
public interface ShopRoleMapper{

    int addShopRole(ShopRole obj);

    int addShopRoleSelective(ShopRole obj);

    int deleteById(int roleId);
                            
    int deleteByIds(String[] ids);

    int updateById(ShopRole shopRole);

    int updateSelectiveById(ShopRole shopRole);

    ShopRole findOne(Integer roleId);
                            
    List<ShopRole> searchShopRole(Map<String, Object> map);


    List<AdminRoleVO> searchAdminRole(Map<String, Object> map);
}