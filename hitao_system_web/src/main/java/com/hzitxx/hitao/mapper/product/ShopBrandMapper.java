package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopBrand;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-28
 */
public interface ShopBrandMapper{

    int addShopBrand(ShopBrand obj);

    int addShopBrandSelective(ShopBrand obj);

    int deleteById(int brandId);
                                            
    int deleteByIds(String[] ids);

    int updateById(ShopBrand shopBrand);

    int updateSelectiveById(ShopBrand shopBrand);

    ShopBrand findOne(Integer brandId);
                                            
    List<ShopBrand> searchShopBrand(@Param("map") Map<String, Object> map);
}