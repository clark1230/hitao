package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.ShopGoodsCategoryMapper;
import com.hzitxx.hitao.service.ShopGoodsCategoryService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.utils.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-05
 */
@Service
public class ShopGoodsCategoryServiceImpl implements ShopGoodsCategoryService {

    @Autowired(required = false)
    private ShopGoodsCategoryMapper mapper;

    @Override
    public ServerResponse addShopGoodsCategory(ShopGoodsCategory shopGoodsCategory){
        int result =  this.mapper.addShopGoodsCategory(shopGoodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopGoodsCategorySelective(ShopGoodsCategory shopGoodsCategory){
        int result =  this.mapper.addShopGoodsCategorySelective(shopGoodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int catId){
        int result = this.mapper.deleteById(catId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result != 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopGoodsCategory shopGoodsCategory){
        int result = this.mapper.updateById(shopGoodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopGoodsCategory shopGoodsCategory){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(shopGoodsCategory));
    }

    @Override
    public  ServerResponse<List<ShopGoodsCategory>> searchShopGoodsCategory(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchShopGoodsCategory(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopGoodsCategory>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopGoodsCategory>  obj=mapper.searchShopGoodsCategory(map);
        PageInfo<ShopGoodsCategory> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopGoodsCategory> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param catId
     * @return
     */
    @Override
    public ServerResponse<ShopGoodsCategory> findOne(Integer catId){
        ShopGoodsCategory shopGoodsCategory = this.mapper.findOne(catId);
        if(shopGoodsCategory == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(shopGoodsCategory);
     }
}

