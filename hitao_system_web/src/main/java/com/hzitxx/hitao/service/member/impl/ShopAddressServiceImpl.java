package com.hzitxx.hitao.service.member.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.member.ShopAddressMapper;
import com.hzitxx.hitao.service.member.IShopAddressService;
import com.hzitxx.hitao.system.pojo.member.ShopAddress;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家地址信息表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
@Service
public class ShopAddressServiceImpl implements IShopAddressService {

    @Autowired(required = false)
    private ShopAddressMapper mapper;

    @Override
    public ServerResponse addShopAddress(ShopAddress shopAddress){
        int result = this.mapper.addShopAddress(shopAddress);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopAddressSelective(ShopAddress shopAddress){
        int result = this.mapper.addShopAddressSelective(shopAddress);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int id){
        int result = this.mapper.deleteById(id);
        if (result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return  ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result > 0){
            return  ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return  ServerResponse.createBySuccessMessage("批量删除成功!");
    }
    @Override
    public  ServerResponse updateById(ShopAddress shopAddress){
        int result = this.mapper.updateById(shopAddress);
        if(result  != 1){
            return  ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopAddress shopAddress){
        int result = this.mapper.updateSelectiveById(shopAddress);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse searchShopAddress(Map<String, Object> map){
        List<ShopAddress> shopAddressList = this.mapper.searchShopAddress(map);
        return  ServerResponse.createBySuccess(shopAddressList);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public LayuiEntity<ShopAddress> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopAddress>  obj=mapper.searchShopAddress(map);
        PageInfo<ShopAddress> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopAddress> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public ServerResponse findOne(Integer id){
        ShopAddress shopAddress = this.mapper.findOne(id);
        if (shopAddress == null){
            return  ServerResponse.createByErrorMessage("该数据不存在!");
        }
        return  ServerResponse.createBySuccess(shopAddress);
     }
}

