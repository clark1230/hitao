package com.hzitxx.hitao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.permission.ShopAdminMapper;
import com.hzitxx.hitao.service.IShopAdminService;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.ShopAdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
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
        ShopAdmin check = this.mapper.checkAdminNameExists(shopAdmin.getAdminName());
        if(check != null){
            return  ServerResponse.createByErrorMessage("该用户已经存在!");
        }
        int result = this.mapper.addShopAdmin(shopAdmin);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加数据失败!");
        }
        return ServerResponse.createBySuccessMessage("添加数据成功!");
    }

    @Override
    public ServerResponse addShopAdminSelective(ShopAdmin shopAdmin){
        ShopAdmin check = this.mapper.checkAdminNameExists(shopAdmin.getAdminName());
        if(check != null){
            return  ServerResponse.createByErrorMessage("该用户已经存在!");
        }
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
        List<ShopAdminVO> shopAdmins = this.mapper.searchShopAdmin(map);
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
    public LayuiEntity<ShopAdminVO> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopAdminVO>  obj=mapper.searchShopAdmin(map);
        PageInfo<ShopAdminVO> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopAdminVO> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
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
            shopAdmin.setAdminLoginNum(shopAdmin.getAdminLoginNum()+1);
            shopAdmin.setLoginTime(new Date());
            this.mapper.updateById(shopAdmin);
            return  shopAdmin;
        }
        return null;
    }

    /**
     * 查询该用户是否存在
     * @param adminName
     * @return
     */
    @Override
    public ServerResponse checkAdminNameExists(String adminName) {
        ShopAdmin shopAdmin = this.mapper.checkAdminNameExists(adminName);
        if(shopAdmin == null){
            return ServerResponse.createBySuccessMessage("该用户可以录入!");
        }
        return ServerResponse.createByErrorMessage("该用户已经存在!");
    }

    /**
     * 系统注销
     * @param adminId
     * @return
     */
    @Override
    public ServerResponse logout(Integer adminId) {
        ShopAdmin shopAdmin = new ShopAdmin();
        shopAdmin.setAdminId(adminId);
        shopAdmin.setLoginStatus(0);
        int result = this.mapper.updateSelectiveById(shopAdmin);
        if(result != 1){
            return ServerResponse.createByErrorMessage("系统注销失败!");
        }
        return ServerResponse.createBySuccessMessage("系统注销成功!");
    }
}

