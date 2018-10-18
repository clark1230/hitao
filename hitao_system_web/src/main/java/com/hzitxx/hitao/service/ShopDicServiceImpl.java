package com.hzitxx.hitao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.settings.ShopDicMapper;
import com.hzitxx.hitao.system.pojo.ShopDic;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-13
 */
@Service
public class ShopDicServiceImpl implements IShopDicService {

    @Autowired
    private ShopDicMapper shopDicMapper;

    @Override
    public ServerResponse addShopDic(ShopDic shopDic){
        int result =  this.shopDicMapper.addShopDic(shopDic);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopDicSelective(ShopDic shopDic){
        int result =  this.shopDicMapper.addShopDicSelective(shopDic);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }




    @Override
    public  ServerResponse updateById(ShopDic shopDic){
        int result = this.shopDicMapper.updateById(shopDic);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopDic shopDic){
        int result = this.shopDicMapper.updateSelectiveById(shopDic);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse<List<ShopDic>> searchShopDic(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.shopDicMapper.searchShopDic(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopDic>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopDic>  obj= shopDicMapper.searchShopDic(map);
        PageInfo<ShopDic> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopDic> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param
     * @return
     */
    @Override
    public ServerResponse<ShopDic> findOne(Integer dicId) {
        ShopDic shopDic = this.shopDicMapper.findOne(dicId);
        if(shopDic == null){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess("查询成功!",shopDic);
    }
}

