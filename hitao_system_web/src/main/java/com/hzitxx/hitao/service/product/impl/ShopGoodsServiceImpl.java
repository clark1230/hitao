package com.hzitxx.hitao.service.product.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.product.ShopGoodsMapper;
import com.hzitxx.hitao.service.product.IShopGoodsService;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-02
 */
@Service
public class ShopGoodsServiceImpl implements IShopGoodsService {

    @Autowired(required = false)
    private ShopGoodsMapper mapper;

    @Override
    public ServerResponse addShopGoods(ShopGoods shopGoods){
        int result = this.mapper.addShopGoods(shopGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息添加成功!");
    }

    @Override
    public ServerResponse addShopGoodsSelective(ShopGoods shopGoods){
        int result = this.mapper.addShopGoodsSelective(shopGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息添加成功!");
    }

    @Override
    public ServerResponse deleteById(int goodsId){
         int result = this.mapper.deleteById(goodsId);
         if(result != 1){
             return  ServerResponse.createByErrorMessage("商品信息删除失败!");
         }
         return ServerResponse.createBySuccessMessage("商品信息添加成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result == 0){
            return ServerResponse.createByErrorMessage("商品信息批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息批量删除成功!");
    }
    @Override
    public  ServerResponse updateById(ShopGoods shopGoods){
        int result =  this.mapper.updateById(shopGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息修改失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息修改成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopGoods shopGoods){
        int result  = this.mapper.updateSelectiveById(shopGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息修改失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息修改成功!");
    }

    @Override
    public  ServerResponse searchShopGoods(Map<String, Object> map){
        List<ShopGoods> shopGoods = this.mapper.searchShopGoods(map);
        return ServerResponse.createBySuccess(shopGoods);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public LayuiEntity<ShopGoods> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopGoods>  obj=mapper.searchShopGoods(map);
        PageInfo<ShopGoods> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopGoods> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
    }

    /**
     * 根据id查询数据
     * @param goodsId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer goodsId){
        ShopGoods shopGoods = this.mapper.findOne(goodsId);
        if(shopGoods == null){
            return ServerResponse.createByErrorMessage("该数据不存在!");
        }
        return ServerResponse.createBySuccess(shopGoods);
     }
}

