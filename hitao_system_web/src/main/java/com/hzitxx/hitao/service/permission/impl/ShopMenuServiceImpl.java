package com.hzitxx.hitao.service.permission.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.permission.IShopMenuService;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.mapper.permission.ShopMenuMapper;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-14
 */
@Service
public class ShopMenuServiceImpl implements IShopMenuService {

    @Autowired(required = false)
    private ShopMenuMapper mapper;

    @Override
    public int addShopMenu(ShopMenu shopMenu){
        return mapper.addShopMenu(shopMenu);
    }

    @Override
    public int addShopMenuSelective(ShopMenu shopMenu){
        return mapper.addShopMenuSelective(shopMenu);
    }

    @Override
    public int deleteById(int mId){
            return mapper.deleteById(mId);
    }

    @Override
    public int deleteByIds(String[]ids){
        return mapper.deleteByIds(ids);
    }
    @Override
    public  int updateById(ShopMenu shopMenu){
        return mapper.updateById(shopMenu);
    }

    @Override
    public  int updateSelectiveById(ShopMenu shopMenu){
        return mapper.updateSelectiveById(shopMenu);
    }

    @Override
    public  List<ShopMenu> searchShopMenu(Map<String, Object> map){
        return mapper.searchShopMenu(map);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public LayuiEntity<ShopMenu> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopMenu>  obj=mapper.searchShopMenu(map);
        PageInfo<ShopMenu> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopMenu> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return layuiEntity;
    }


    /**
     * 根据id查询数据
     * @param mId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer mId){
        ShopMenu shopMenu = this.mapper.findOne(mId);
        if(shopMenu == null){
            return ServerResponse.createByErrorMessage("获取数据失败!");
        }
        return ServerResponse.createBySuccess(shopMenu);
     }

    /**
     * 获取菜单数据
     * @return
     */
    @Override
    public ServerResponse menuData() {

        List<ShopMenu> shopMenuList = this.mapper.searchByParentId(0);
        if(shopMenuList != null && shopMenuList.size() >0){
            for(ShopMenu sm: shopMenuList){
                List<ShopMenu> sub2 = this.mapper.searchByParentId(sm.getId());
                sm.setChildren(sub2);
                if(sub2 != null && sub2.size() >0){
                    for(ShopMenu sm2: sub2){
                        List<ShopMenu> sub3 = this.mapper.searchByParentId(sm.getId());
                        sm2.setChildren(sub3);
                    }
                }
            }
        }
        return ServerResponse.createBySuccess(shopMenuList);
    }


}

