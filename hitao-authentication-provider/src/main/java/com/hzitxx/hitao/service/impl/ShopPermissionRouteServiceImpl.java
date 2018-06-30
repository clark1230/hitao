package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.mapper.permission.ShopPermissionRouteMapper;
import com.hzitxx.hitao.service.IShopPermissionRouteService;
import com.hzitxx.hitao.system.pojo.permission.ShopPermissionRoute;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-21
 */
@Service
public class ShopPermissionRouteServiceImpl implements IShopPermissionRouteService {

    @Autowired
    private ShopPermissionRouteMapper mapper;

    @Override
    public int addShopPermissionRoute(ShopPermissionRoute shopPermissionRoute){
        return mapper.addShopPermissionRoute(shopPermissionRoute);
    }

    @Override
    public int addShopPermissionRouteSelective(ShopPermissionRoute shopPermissionRoute){
        return mapper.addShopPermissionRouteSelective(shopPermissionRoute);
    }

    @Override
    public int deleteById(int routeId){
            return mapper.deleteById(routeId);
    }

    @Override
    public int deleteByIds(String[]ids){
        return mapper.deleteByIds(ids);
    }
    @Override
    public  int updateById(ShopPermissionRoute shopPermissionRoute){
        return mapper.updateById(shopPermissionRoute);
    }

    @Override
    public  int updateSelectiveById(ShopPermissionRoute shopPermissionRoute){
        return mapper.updateSelectiveById(shopPermissionRoute);
    }

    @Override
    public ServerResponse<List<ShopPermissionRoute>> searchShopPermissionRoute(Map<String, Object> map){
        List<ShopPermissionRoute> shopPermissionRoutes = this.mapper.searchShopPermissionRoute(map);
        if(shopPermissionRoutes.size() == 0){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(shopPermissionRoutes);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public LayuiEntity<ShopPermissionRoute> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopPermissionRoute>  obj=mapper.searchShopPermissionRoute(map);
        PageInfo<ShopPermissionRoute> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopPermissionRoute> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
    }

    /**
     * 根据id查询数据
     * @param routeId
     * @return
     */
    @Override
    public ShopPermissionRoute findOne(Integer routeId){
            return mapper.findOne(routeId);
     }

    /**
     * 获取菜单信息
     * @return
     */
    @Override
    public ServerResponse menuTree() {
        List<ShopPermissionRoute> shopPermissionRoutes = this.mapper.findByParentId(0);
        for(ShopPermissionRoute route: shopPermissionRoutes){
                List<ShopPermissionRoute> subRoutes = this.mapper.findByParentId(route.getRouteId());
                route.setChildren(subRoutes);
        }
        return ServerResponse.createBySuccess(shopPermissionRoutes);
    }
    private void tree(List<ShopPermissionRoute> treeData){
        List<ShopPermissionRoute> shopPermissionRoutes = this.mapper.findByParentId(0);
        for(ShopPermissionRoute route: shopPermissionRoutes){

        }
    }

}

