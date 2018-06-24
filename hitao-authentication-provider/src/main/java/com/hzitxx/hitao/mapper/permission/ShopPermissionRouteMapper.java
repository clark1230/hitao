package com.hzitxx.hitao.mapper.permission;


import com.hzitxx.hitao.system.pojo.permission.ShopPermissionRoute;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-21
 */
public interface ShopPermissionRouteMapper{

    int addShopPermissionRoute(ShopPermissionRoute obj);

    int addShopPermissionRouteSelective(ShopPermissionRoute obj);

    int deleteById(int routeId);
                        
    int deleteByIds(String[] ids);

    int updateById(ShopPermissionRoute shopPermissionRoute);

    int updateSelectiveById(ShopPermissionRoute shopPermissionRoute);

    ShopPermissionRoute findOne(Integer routeId);
                        
    List<ShopPermissionRoute> searchShopPermissionRoute(@Param("map") Map<String, Object> map);

    /**
     * 根据父级编号查询数据
     * @param parentId
     * @return
     */
    List<ShopPermissionRoute> findByParentId(Integer parentId);
}