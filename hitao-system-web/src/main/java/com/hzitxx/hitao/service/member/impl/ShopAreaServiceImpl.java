package com.hzitxx.hitao.service.member.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.member.ShopAreaMapper;
import com.hzitxx.hitao.service.member.IShopAreaService;
import com.hzitxx.hitao.system.pojo.member.ShopArea;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
@Service
public class ShopAreaServiceImpl implements IShopAreaService {

    @Autowired(required = false)
    private ShopAreaMapper mapper;

    @Override
    public ServerResponse addShopArea(ShopArea shopArea){
        int result = this.mapper.addShopArea(shopArea);
        if (result !=1){
            return  ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopAreaSelective(ShopArea shopArea){
        int result =  mapper.addShopAreaSelective(shopArea);
        if(result!=1){
            return  ServerResponse.createByErrorMessage("添加失败!");
        }
        return  ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int areaId){
        int result = mapper.deleteById(areaId);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result =  mapper.deleteByIds(ids);
        if(result >0){
            return  ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return  ServerResponse.createBySuccessMessage("批量删除成功!");
    }
    @Override
    public  ServerResponse updateById(ShopArea shopArea){
        int result =  mapper.updateById(shopArea);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("编辑失败!");
        }
        return  ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopArea shopArea){
        int result =  mapper.updateSelectiveById(shopArea);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("编辑失败!");
        }
        return  ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse searchShopArea(Map<String, Object> map){
        List<ShopArea> shopAreas =  mapper.searchShopArea(map);
        if(shopAreas == null){
            return  ServerResponse.createByErrorMessage("获取数据失败!");
        }
        return  ServerResponse.createBySuccess(shopAreas);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopArea>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopArea>  obj=mapper.searchShopArea(map);
        PageInfo<ShopArea> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopArea> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param areaId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer areaId){
        ShopArea shopArea = mapper.findOne(areaId);
        if(shopArea == null){
            return  ServerResponse.createByErrorMessage("该数据不存在!");
        }
        return  ServerResponse.createBySuccess(shopArea);
    }
}

