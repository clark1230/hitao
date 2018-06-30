package com.hzitxx.hitao.service.product.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.product.vo.ShopGoodsCategoryVo;
import com.hzitxx.hitao.mapper.product.ShopGoodsCategoryMapper;
import com.hzitxx.hitao.service.product.IShopGoodsCategoryService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsCategory;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-03
 */
@Service
public class ShopGoodsCategoryServiceImpl implements IShopGoodsCategoryService {

    @Autowired(required = false)
    private ShopGoodsCategoryMapper mapper;

    @Override
    public ServerResponse addShopGoodsCategory(ShopGoodsCategory shopGoodsCategory){
        int result = this.mapper.addShopGoodsCategory(shopGoodsCategory);
        if( result !=  1){
            return ServerResponse.createByErrorMessage("添加类目信息失败!");
        }
        return ServerResponse.createBySuccessMessage("添加类目信息成功!");
    }

    @Override
    public ServerResponse addShopGoodsCategorySelective(ShopGoodsCategory shopGoodsCategory){
        int result = this.mapper.addShopGoodsCategorySelective(shopGoodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加类目信息失败!");
        }
        return ServerResponse.createBySuccessMessage("添加类目信息成功!");
    }

    @Override
    public ServerResponse deleteById(int catId){
        int result = this.mapper.deleteById(catId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除类目信息失败!");
        }
        return ServerResponse.createBySuccessMessage("删除类目信息成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result  == 0){
            return ServerResponse.createByErrorMessage("批量删除类目信息失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除类目信息成功!");
    }

    @Override
    public  ServerResponse updateById(ShopGoodsCategory shopGoodsCategory){
        int result = this.mapper.updateById(shopGoodsCategory);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("修改类目信息失败!");
        }
        return ServerResponse.createBySuccessMessage("修改类目信息成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopGoodsCategory shopGoodsCategory){
        int result = this.mapper.updateSelectiveById(shopGoodsCategory);
        if( result != 1){
            return ServerResponse.createByErrorMessage("修改类目信息失败!");
        }
        return ServerResponse.createBySuccessMessage("修改类目信息成功!");
    }

    @Override
    public  ServerResponse searchShopGoodsCategory(Map<String, Object> map){
        List<ShopGoodsCategory> shopGoodsCategories = this.mapper.searchShopGoodsCategory(map);
        return ServerResponse.createBySuccess(shopGoodsCategories);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public LayuiEntity<ShopGoodsCategory> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopGoodsCategory>  obj=mapper.searchShopGoodsCategory(map);
        PageInfo<ShopGoodsCategory> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopGoodsCategory> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
    }

    /**
     * 根据id查询数据
     * @param catId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer catId){
        ShopGoodsCategory shopGoodsCategory = this.mapper.findOne(catId);
        if(shopGoodsCategory == null){
            return  ServerResponse.createByErrorMessage("没有该数据!");
        }
        return ServerResponse.createBySuccess(shopGoodsCategory);
     }


    /**
     * 类目信息
     * @return
     */
    @Override
    public ServerResponse ajaxCate() {
        List<ShopGoodsCategoryVo> list = new ArrayList<>();
        this.findParentCate(list,0);
        return ServerResponse.createBySuccess(list);
    }

    /**
     * 递归封装类目信息
     * @param list
     * @param parentId
     * @return
     */
    private List<ShopGoodsCategoryVo> findParentCate(List<ShopGoodsCategoryVo> list, int parentId){
        List<ShopGoodsCategory> goodsCategories = this.mapper.findByPId(parentId);
        ShopGoodsCategoryVo categoryVo = null;
        if(goodsCategories!= null && goodsCategories.size() >0){
            for(ShopGoodsCategory gc: goodsCategories){
                categoryVo = new ShopGoodsCategoryVo();
                categoryVo.setValue(gc.getCatId());
                categoryVo.setLabel(gc.getCatName());
                list.add(categoryVo);
                categoryVo.setChildren(findParentCate(new ArrayList<ShopGoodsCategoryVo>(),gc.getCatId()));//递归查询自己类目信息
            }
        }else{
            return null;
        }
        return list;
    }
}

