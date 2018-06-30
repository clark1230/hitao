package com.hzitxx.hitao.mapper;


import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家收藏表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-08
 */
public interface ShopFavoritesMapper{

    int addShopFavorites(ShopFavorites obj);

    int addShopFavoritesSelective(ShopFavorites obj);

    int deleteById(int favId);
                            
    int deleteByIds(String[] ids);

    int updateById(ShopFavorites shopFavorites);

    int updateSelectiveById(ShopFavorites shopFavorites);

    ShopFavorites findOne(Integer favId);
                            
    List<ShopFavorites> searchShopFavorites(@Param("map") Map<String, Object> map);
}