package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.member.ShopAddress;
import com.hzitxx.hitao.mapper.ShopAddressMapper;
import com.hzitxx.hitao.service.IShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家地址信息表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-04
 */
@Service
public class ShopAddressServiceImpl implements IShopAddressService {

    @Autowired
    private ShopAddressMapper mapper;

    private ServerResponse fallback(){
        return ServerResponse.createByErrorMessage("会员服务调用失败!");
    }

    public ServerResponse addShopAddress(ShopAddress shopAddress){
        commons(shopAddress);
        int result = this.mapper.addShopAddress(shopAddress);
        if(result !=1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    private void commons(ShopAddress shopAddress) {
        if(shopAddress.getIsDefault().equals(1)){
            //检查是否存在默认收货地址
            ShopAddress sa = this.mapper.checkDefaultShopAddress(shopAddress.getMemberId());
            System.out.println(sa);
            //修改为非默认地址
            sa.setIsDefault(0);
            this.mapper.updateSelectiveById(sa);
        }
    }


    @Override
    public ServerResponse addShopAddressSelective(ShopAddress shopAddress){
        commons(shopAddress);
        int result = this.mapper.addShopAddressSelective(shopAddress);
        if(result !=1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int id){
        int result = this.mapper.deleteById(id);
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
    public  ServerResponse updateById(ShopAddress shopAddress){
        int result = this.mapper.updateById(shopAddress);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Transactional
    @Override
    public  ServerResponse updateSelectiveById(ShopAddress shopAddress){
        if(shopAddress.getIsDefault() ==1){
            commons(shopAddress);
        }
        int result = this.mapper.updateSelectiveById(shopAddress);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse searchShopAddress(Map<String, Object> map){
        return ServerResponse.createBySuccess(mapper.searchShopAddress(map));
    }


    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public ServerResponse findOne(Integer id){
        ShopAddress shopAddress = this.mapper.findOne(id);
        if(shopAddress == null){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(shopAddress);
    }

    /**
     * 获取会员默认的收货地址
     * @param memberId
     * @return
     */
    @Override
    public ServerResponse searchDefaultAddress(Integer memberId) {
        ShopAddress shopAddress = this.mapper.searchDefaulAddress(memberId);
        if(shopAddress == null){
            return ServerResponse.createByErrorMessage("没有默认的收货地址!");

        }
        return ServerResponse.createBySuccess(shopAddress);
    }
}

