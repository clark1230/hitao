package com.hzitxx.hitao.mapper.product;


import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-02
 */
public interface ShopGoodsMapper{

    int addShopGoods(ShopGoods obj);

    int addShopGoodsSelective(ShopGoods obj);

    int deleteById(int goodsId);
                                                                                                                
    int deleteByIds(String[] ids);

    int updateById(ShopGoods shopGoods);

    int updateSelectiveById(ShopGoods shopGoods);

    ShopGoods findOne(Integer goodsId);
                                                                                                                
    List<ShopGoods> searchShopGoods(@Param("map") Map<String, Object> map);
}