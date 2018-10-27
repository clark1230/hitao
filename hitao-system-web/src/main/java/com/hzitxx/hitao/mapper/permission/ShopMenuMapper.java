package com.hzitxx.hitao.mapper.permission;

import com.hzitxx.hitao.system.pojo.permission.ShopMenu;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台菜单表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
public interface ShopMenuMapper{

    int addShopMenu(ShopMenu obj);

    int addShopMenuSelective(ShopMenu obj);

    int deleteById(int mId);
                                
    int deleteByIds(String[] ids);

    int updateById(ShopMenu shopMenu);

    int updateSelectiveById(ShopMenu shopMenu);

    ShopMenu findOne(Integer mId);
                                
    List<ShopMenu> searchShopMenu(@Param("map") Map<String, Object> map);

    /**
     * 根据父级编号查询数据
     * @param parentId
     * @return
     */
    List<ShopMenu> searchByParentId(int parentId);

    ShopMenu searchById(int id);
}