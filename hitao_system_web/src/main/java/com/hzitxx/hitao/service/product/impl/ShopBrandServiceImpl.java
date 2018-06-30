package com.hzitxx.hitao.service.product.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.product.ShopBrandMapper;
import com.hzitxx.hitao.service.product.IShopBrandService;
import com.hzitxx.hitao.system.pojo.product.ShopBrand;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-28
 */
@Service
public class ShopBrandServiceImpl implements IShopBrandService {

    @Autowired(required = false)
    private ShopBrandMapper mapper;

    @Override
    public ServerResponse addShopBrand(ShopBrand shopBrand){
        int result = this.mapper.addShopBrand(shopBrand);
        if(result !=1){
            return ServerResponse.createByErrorMessage("添加商品信息失败!");
        }
        return ServerResponse.createBySuccessMessage("添加商品信息成功!");
    }

    @Override
    public ServerResponse addShopBrandSelective(ShopBrand shopBrand){
        int result =  this.mapper.addShopBrandSelective(shopBrand);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("添加商品信息失败!");
        }
        return ServerResponse.createBySuccessMessage("添加商品信息成功!");
    }

    @Override
    public ServerResponse deleteById(int brandId){
        int result = this.mapper.deleteById(brandId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("根据品牌id删除数据失败!");
        }
        return ServerResponse.createBySuccessMessage("根据品牌id删除数据成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result == 0){
            return ServerResponse.createByErrorMessage("批量删除品牌信息失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除品牌信息成功!");
    }
    @Override
    public ServerResponse updateById(ShopBrand shopBrand){
        int result = this.mapper.updateById(shopBrand);
        if(result != 1) {
            return ServerResponse.createByErrorMessage("编辑品牌信息失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑品牌信息成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopBrand shopBrand){
        int  result = this.mapper.updateSelectiveById(shopBrand);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("编辑品牌信息失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑品牌信息成功!");
    }

    @Override
    public  ServerResponse searchShopBrand(Map<String, Object> map){
        List<ShopBrand> shopBrandList = this.mapper.searchShopBrand(map);
        if(shopBrandList != null && shopBrandList.size() == 0){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(shopBrandList);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public LayuiEntity<ShopBrand> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopBrand>  obj=mapper.searchShopBrand(map);
        PageInfo<ShopBrand> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopBrand> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
    }

    /**
     * 根据id查询数据
     * @param brandId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer brandId){
        ShopBrand shopBrand = this.mapper.findOne(brandId);
        if(shopBrand == null){
            return  ServerResponse.createByErrorMessage("该数据不存在!");
        }
        return ServerResponse.createBySuccess(shopBrand);
     }
}

