package com.hzitxx.hitao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.permission.ShopMenuMapper;
import com.hzitxx.hitao.service.IShopMenuService;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.ShopMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse addShopMenuSelective(ShopMenu shopMenu){
        int result = this.mapper.addShopMenuSelective(shopMenu);
        if(result !=1){
            return ServerResponse.createByErrorMessage("权限信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("权限信息添加成功!");
    }

    @Override
    public ServerResponse deleteById(int mId){
        int result = this.mapper.deleteById(mId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result == 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopMenu shopMenu){
        int result = this.mapper.updateById(shopMenu);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑权限信息失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑权限信息成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopMenu shopMenu){
        int result = this.mapper.updateSelectiveById(shopMenu);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑权限信息失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑权限信息成功!");
    }

//    @Override
//    public  List<ShopMenuVO> searchShopMenu(Map<String, Object> map){
//        return mapper.searchShopMenu(map);
//    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopMenuVO>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopMenuVO>  obj=mapper.searchShopMenu(map);
        PageInfo<ShopMenuVO> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopMenuVO> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
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
                        List<ShopMenu> sub3 = this.mapper.searchByParentId(sm2.getId());
                        sm2.setChildren(sub3);
                        if(sub3!= null && sub3.size() >0 ){
                            for(ShopMenu sm3 : sub3){
                                List<ShopMenu> sub4 = this.mapper.searchByParentId(sm3.getId());
                                sm3.setChildren(sub4);
                            }
                        }
                    }
                }
            }
        }
        return ServerResponse.createBySuccess(shopMenuList);
    }


}

