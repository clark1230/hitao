package com.hzitxx.hitao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.mapper.permission.ShopRoleMapper;
import com.hzitxx.hitao.mapper.permission.ShopRoleMenuMapper;
import com.hzitxx.hitao.service.IShopRoleService;
import com.hzitxx.hitao.system.pojo.permission.ShopRoleMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.AdminRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台后台角色 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
@Service
public class ShopRoleServiceImpl implements IShopRoleService {

    @Autowired(required = false)
    private ShopRoleMapper mapper;

    @Autowired
    private ShopRoleMenuMapper shopRoleMenuMapper;


    @Override
    public ServerResponse addShopRole(ShopRole shopRole){
        int result = mapper.addShopRole(shopRole);
        if(result != 1){
            return ServerResponse.createByErrorMessage("角色信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("角色信息添加成功!");
    }

    @Override
    public ServerResponse addShopRoleSelective(ShopRole shopRole){
        int result = this.mapper.addShopRoleSelective(shopRole);
        if(result != 1){
            return ServerResponse.createByErrorMessage("角色信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("角色信息添加成功!");
    }

    @Override
    public ServerResponse deleteById(int roleId){
        int result = this.mapper.deleteById(roleId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除角色信息失败!");
        }
        return ServerResponse.createBySuccessMessage("删除角色信息成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[] ids){
        int result = this.mapper.deleteByIds(ids);
        if(result == 0){
            return ServerResponse.createByErrorMessage("批量删除角色信息失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除角色信息成功!");
    }

    @Override
    public  ServerResponse updateById(ShopRole shopRole){
        int result = this.mapper.updateById(shopRole);
        if(result != 1){
            return ServerResponse.createByErrorMessage("角色信息修改失败!");
        }
        return ServerResponse.createBySuccessMessage("角色信息修改成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopRole shopRole){
        int result = this.mapper.updateSelectiveById(shopRole);
        if(result != 1) {
            return  ServerResponse.createByErrorMessage("角色信息修改失败!");
        }
        return ServerResponse.createBySuccessMessage("角色信息修改成功!");
    }

    @Override
    public  ServerResponse<List<ShopRole>> searchShopRole(Map<String, Object> map){
        List<ShopRole> shopRoleList =  this.mapper.searchShopRole(map);
        if(shopRoleList == null || shopRoleList.size() == 0){
            return ServerResponse.createByErrorMessage("获取角色信息失败!");
        }
        return ServerResponse.createBySuccess("角色信息",shopRoleList);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<AdminRoleVO>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<AdminRoleVO>  obj=mapper.searchAdminRole(map);
        PageInfo<AdminRoleVO> pageInfo=new PageInfo<>(obj);
        LayuiEntity<AdminRoleVO> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param roleId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer roleId){
        ShopRole shopRole = this.mapper.findOne(roleId);
        if(shopRole == null){
            return ServerResponse.createByErrorMessage("获取角色信息失败！");
        }
        return ServerResponse.createBySuccess(shopRole);
     }

    /**
     * 角色授权
     * @param roleId
     * @param permissionIds
     * @return
     */
    @Override
    public ServerResponse<String> grantPermssion(Integer roleId, Integer[] permissionIds) {
        try{
            if(permissionIds != null){
                this.shopRoleMenuMapper.deleteByRoleId(roleId);
                for(Integer permissionId: permissionIds){
                    this.shopRoleMenuMapper.addShopRoleMenuSelective(new ShopRoleMenu(roleId,permissionId));
                }
            }
            return ServerResponse.createBySuccessMessage("授权成功!");
        }catch (Exception e){
            return ServerResponse.createByErrorMessage("授权失败!");
        }
    }


}

