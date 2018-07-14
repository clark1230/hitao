package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopGoodsContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品内容表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-14
 */
public interface ShopGoodsContentMapper{

    int addShopGoodsContent(ShopGoodsContent obj);

    int addShopGoodsContentSelective(ShopGoodsContent obj);

    int deleteById(int goodsId);
                
    int deleteByIds(String[] ids);

    int updateById(ShopGoodsContent shopGoodsContent);

    int updateSelectiveById(ShopGoodsContent shopGoodsContent);

    ShopGoodsContent findOne(Integer goodsId);
                
    List<ShopGoodsContent> searchShopGoodsContent(@Param("map") Map<String, Object> map);
}