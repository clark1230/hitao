package com.hzitxx.hitao.service.permission.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.permission.IShopAdminService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.mapper.permission.ShopAdminMapper;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-15
 */
@Service
public class ShopAdminServiceImpl implements IShopAdminService {

    @Autowired(required = false)
    private ShopAdminMapper mapper;

    @Override
    public ServerResponse addShopAdmin(ShopAdmin shopAdmin){
        int result = this.mapper.addShopAdmin(shopAdmin);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加数据失败!");
        }
        return ServerResponse.createBySuccessMessage("添加数据成功!");
    }

    @Override
    public ServerResponse addShopAdminSelective(ShopAdmin shopAdmin){
        int result = this.mapper.addShopAdminSelective(shopAdmin);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加数据失败!");
        }
        return ServerResponse.createBySuccessMessage("添加数据成功!");
    }

    @Override
    public ServerResponse deleteById(int adminId){
        int result = this.mapper.deleteById(adminId);
        if(result !=1){
            return ServerResponse.createByErrorMessage("删除数据失败!");
        }
        return  ServerResponse.createBySuccessMessage("删除数据成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result  == 0){
            return ServerResponse.createByErrorMessage("批量删除数据失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除数据成功!");
    }
    @Override
    public  ServerResponse updateById(ShopAdmin shopAdmin){
        int result = this.mapper.updateById(shopAdmin);
        if(result  != 1){
            return ServerResponse.createByErrorMessage("修改数据失败!");
        }
        return ServerResponse.createBySuccessMessage("修改数据成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopAdmin shopAdmin){
        int result = this.mapper.updateSelectiveById(shopAdmin);
        if(result !=1){
            return ServerResponse.createByErrorMessage("修改数据失败!");
        }
        return ServerResponse.createBySuccessMessage("修改数据成功!");
    }

    @Override
    public  ServerResponse searchShopAdmin(Map<String, Object> map){
        List<ShopAdmin> shopAdmins = this.mapper.searchShopAdmin(map);
        return ServerResponse.createBySuccess(shopAdmins);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopAdmin>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopAdmin>  obj=mapper.searchShopAdmin(map);
        PageInfo<ShopAdmin> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopAdmin> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param adminId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer adminId){
        ShopAdmin shopAdmin = this.mapper.findOne(adminId);
        if(shopAdmin == null){
            return ServerResponse.createByErrorMessage("查询数据失败!");
        }
        return ServerResponse.createBySuccess(shopAdmin);
     }

    /**
     * 根据编号查询数据
     * @param adminId
     * @return
     */
    @Override
    public ShopAdmin findById(Serializable adminId) {
        return this.mapper.findOne((Integer)adminId);
    }

    /**
     * 处理登陆逻辑
     * @param shopAdmin
     * @return
     */
    @Transactional
    @Override
    public ShopAdmin login(ShopAdmin shopAdmin) {
        shopAdmin = this.mapper.login(shopAdmin);
        if(shopAdmin != null){
            //修改状态
            shopAdmin.setLoginStatus(1);
            this.mapper.updateById(shopAdmin);
            return  shopAdmin;
        }
        return  null;
    }

    /**
     * 处理登陆
     * @param adminName
     * @return
     */
    @Override
    public ShopAdmin login(String adminName) {
        ShopAdmin shopAdmin = this.mapper.loginByAdminName(adminName);
        if(shopAdmin != null){
            //修改状态
            shopAdmin.setLoginStatus(1);
            this.mapper.updateById(shopAdmin);
            return  shopAdmin;
        }
        return null;
    }
}

