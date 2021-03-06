package com.hzitxx.hitao.service.product;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.product.ShopBrand;
import com.hzitxx.hitao.util.LayuiEntity;
import com.hzitxx.hitao.vo.shopcategory.ShopGoodsCategoryVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-28
 */

public interface IShopBrandService  {

    ServerResponse addShopBrand(ShopBrand shopBrand);

    ServerResponse addShopBrandSelective(ShopBrand obj);

    ServerResponse deleteById(int brandId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopBrand shopBrand);

    ServerResponse updateSelectiveById(ShopBrand shopBrand);

    ServerResponse searchShopBrand(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopBrand>> page(int page, int limit, Map<String, Object> map);


    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer brandId);


    /**
     * 批量逻辑删除数据
     * @param brandIds
     * @return
     */
    ServerResponse removeBatch(Integer[] brandIds);

}
