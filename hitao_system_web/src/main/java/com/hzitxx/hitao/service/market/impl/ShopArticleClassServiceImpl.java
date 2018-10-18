package com.hzitxx.hitao.service.market.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.market.ShopArticleClassMapper;
import com.hzitxx.hitao.service.market.IShopArticleClassService;
import com.hzitxx.hitao.system.pojo.market.ShopArticleClass;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
@Service
public class ShopArticleClassServiceImpl implements IShopArticleClassService {

    @Autowired
    private ShopArticleClassMapper shopArticleClassMapper;

    @Override
    public ServerResponse addShopArticleClass(ShopArticleClass shopArticleClass){
        int result =  this.shopArticleClassMapper.addShopArticleClass(shopArticleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopArticleClassSelective(ShopArticleClass shopArticleClass){
        int result =  this.shopArticleClassMapper.addShopArticleClassSelective(shopArticleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int acId){
        int result = this.shopArticleClassMapper.deleteById(acId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.shopArticleClassMapper.deleteByIds(ids);
        if(result != 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopArticleClass shopArticleClass){
        int result = this.shopArticleClassMapper.updateById(shopArticleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopArticleClass shopArticleClass){
        int result = shopArticleClassMapper.updateSelectiveById(shopArticleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse<List<ShopArticleClass>> searchShopArticleClass(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.shopArticleClassMapper.searchShopArticleClass(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopArticleClass>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopArticleClass>  obj= shopArticleClassMapper.searchShopArticleClass(map);
        PageInfo<ShopArticleClass> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopArticleClass> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param acId
     * @return
     */
    @Override
    public ServerResponse<ShopArticleClass> findOne(Integer acId){
        ShopArticleClass shopArticleClass = this.shopArticleClassMapper.findOne(acId);
        if(shopArticleClass == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(shopArticleClass);
     }
}

