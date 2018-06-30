package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.ShopFavoritesMapper;
import com.hzitxx.hitao.rpc.ShopGoodsService;
import com.hzitxx.hitao.service.IShopFavoritesService;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家收藏表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-08
 */
@Service
public class ShopFavoritesServiceImpl implements IShopFavoritesService {

    @Autowired
    private ShopFavoritesMapper mapper;


    @Autowired
    private ShopGoodsService shopGoodsService;

    /**
     * 添加商品收藏信息
     * @param shopFavorites
     * @return
     */
    @Override
    public ServerResponse addShopFavorites(ShopFavorites shopFavorites){
        int result = this.mapper.addShopFavorites(shopFavorites);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加收藏商品信息失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    /**
     * 添加或者取消收藏
     * @param shopFavorites  收藏信息实体
     * @param type 操作类型 0:添加  1:取消
     * @return
     */
    @Override
    public ServerResponse addOrDelete(ShopFavorites shopFavorites,Integer type){
        if(!Integer.valueOf(0).equals(type) && !Integer.valueOf(1).equals(type)){
            return ServerResponse.createByErrorMessage("type类型参数不正确!");
        }
        int result = 0;
        if(Integer.valueOf(0).equals(type)){
            // 插入之前先判断
            Map<String,Object> paramsMap = new HashMap<>();
            paramsMap.put("memberId",shopFavorites.getMemberId());
            paramsMap.put("goodsId",shopFavorites.getGoodsId());
            List<ShopFavorites> shopFavoritesList =this.mapper.searchShopFavorites(paramsMap);
            ShopFavorites favorites = (shopFavoritesList.size() >0 )?shopFavoritesList.get(0):null;
            if(favorites != null){
                return ServerResponse.createByErrorMessage("该商品已被收藏!");
            }else{
                ShopGoods shopGoods =  this.shopGoodsService.findById(shopFavorites.getGoodsId()).getData();
                BeanUtils.copyProperties(shopGoods,shopFavorites);
                shopFavorites.setFavTime(new Date());
                result = this.mapper.addShopFavoritesSelective(shopFavorites);
                if(result != 1){
                    return  ServerResponse.createByErrorMessage("添加失败!");
                }
                return ServerResponse.createBySuccess("添加成功!","add");
            }

        }else{
            result = this.mapper.deleteById(0);
            if(result !=1){
                return  ServerResponse.createByErrorMessage("取消收藏失败!");
            }
            return ServerResponse.createBySuccess("取消收藏成功!","cancel");
        }

    }

    /**
     * 根据id删除收藏信息
     * @param favId
     * @return
     */
    @Override
    public ServerResponse deleteById(int favId){
        int result = this.mapper.deleteById(favId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    /**
     * 批量删除收藏信息
     * @param ids
     * @return
     */
    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result  == 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    /**
     * 编辑收藏信息
     * @param shopFavorites
     * @return
     */
    @Override
    public  ServerResponse updateById(ShopFavorites shopFavorites){
        int result = this.mapper.updateById(shopFavorites);
        if(result != 1){
            return ServerResponse.createByErrorMessage("修改失败!");
        }
        return ServerResponse.createBySuccessMessage("修改成功!");
    }

    /**
     * 编辑收藏信息
     * @param shopFavorites
     * @return
     */
    @Override
    public  ServerResponse updateSelectiveById(ShopFavorites shopFavorites){
        int result = this.mapper.updateSelectiveById(shopFavorites);
        if(result != 1){
            return ServerResponse.createByErrorMessage("修改失败!");
        }
        return ServerResponse.createBySuccessMessage("修改成功!");
    }

    /**
     * 查询收藏信息
     * @param map
     * @return
     */
    @Override
    public  ServerResponse<List<ShopFavorites>> searchShopFavorites(Map<String, Object> map){
        List<ShopFavorites> shopFavorites = this.mapper.searchShopFavorites(map);
        if(shopFavorites == null || shopFavorites.size() == 0){
            return ServerResponse.createByErrorMessage("获取商品收藏信息失败!");
        }
        return ServerResponse.createBySuccess(shopFavorites);
    }


    /**
     * 根据id查询数据
     * @param favId
     * @return
     */
    @Override
    public ServerResponse<ShopFavorites> findOne(Integer favId){
        ShopFavorites shopFavorites = this.mapper.findOne(favId);
        if(shopFavorites == null){
            return ServerResponse.createByErrorMessage("根据id查询收藏信息失败!");
        }
        return  ServerResponse.createBySuccess(shopFavorites);
     }

    /**
     * 检查商品是否被收藏了
     * @param memberId
     * @param goodsId
     * @return
     */
    @Override
    public ServerResponse<ShopFavorites> checkFavorites(Integer memberId, Integer goodsId) {
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("memberId",memberId);
        paramsMap.put("goodsId",goodsId);
        List<ShopFavorites> shopFavorites = this.mapper.searchShopFavorites(paramsMap);
        if(shopFavorites.size() == 0){
            return  ServerResponse.createByErrorMessage("检查失败!!");
        }
        return ServerResponse.createBySuccess(shopFavorites.get(0));
    }
}

