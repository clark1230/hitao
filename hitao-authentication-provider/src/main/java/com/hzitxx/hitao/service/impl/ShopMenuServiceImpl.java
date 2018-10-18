package com.hzitxx.hitao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.permission.ShopMenuMapper;
import com.hzitxx.hitao.service.IShopMenuService;
import com.hzitxx.hitao.system.pojo.permission.ShopMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.vo.shopmenu.ShopMenuVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private ShopMenuMapper shopMenuMapper;

    @Autowired
    private Mapper mapper;

    @Override
    public int addShopMenu(ShopMenu shopMenu){
        return shopMenuMapper.addShopMenu(shopMenu);
    }

    @Override
    public ServerResponse addShopMenuSelective(ShopMenu shopMenu){
        int result = this.shopMenuMapper.addShopMenuSelective(shopMenu);
        if(result !=1){
            return ServerResponse.createByErrorMessage("权限信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("权限信息添加成功!");
    }

    @Override
    public ServerResponse deleteById(int mId){
        int result = this.shopMenuMapper.deleteById(mId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.shopMenuMapper.deleteByIds(ids);
        if(result == 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopMenu shopMenu){
        int result = this.shopMenuMapper.updateById(shopMenu);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑权限信息失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑权限信息成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopMenu shopMenu){
        int result = this.shopMenuMapper.updateSelectiveById(shopMenu);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑权限信息失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑权限信息成功!");
    }

//    @Override
//    public  List<ShopMenuVO> searchShopMenu(Map<String, Object> map){
//        return shopMenuMapper.searchShopMenu(map);
//    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopMenu>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopMenu>  obj= shopMenuMapper.searchShopMenu(map);
        PageInfo<ShopMenu> pageInfo=new PageInfo<ShopMenu>(obj);
        LayuiEntity<ShopMenu> layuiEntity=new LayuiEntity<>();
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
        ShopMenu shopMenu = this.shopMenuMapper.findOne(mId);
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
        List<ShopMenu> shopMenuList = this.shopMenuMapper.searchByParentId(0);
        List<ShopMenuVO> shopMenuVOList = this.converList(shopMenuList,new ArrayList<ShopMenuVO>());
        if(shopMenuList != null && shopMenuList.size() >0){
            for(ShopMenuVO sm: shopMenuVOList){
                List<ShopMenu> sub2 = this.shopMenuMapper.searchByParentId(sm.getId());
                List<ShopMenuVO> subVo2 = this.converList(sub2,new ArrayList<ShopMenuVO>());
                sm.setChildren(subVo2);
                if(sub2 != null && sub2.size() >0){
                    for(ShopMenuVO sm2: subVo2){
                        List<ShopMenu> sub3 = this.shopMenuMapper.searchByParentId(sm2.getId());
                        List<ShopMenuVO> subVo3 = this.converList(sub3,new ArrayList<ShopMenuVO>());
                        sm2.setChildren(subVo3);
                        if(sub3!= null && sub3.size() >0 ){
                            for(ShopMenuVO sm3 : subVo3){
                                List<ShopMenu> sub4 = this.shopMenuMapper.searchByParentId(sm3.getId());
                                sm3.setChildren(this.converList(sub4,new ArrayList<ShopMenuVO>()));
                            }
                        }
                    }
                }
            }
        }
        return ServerResponse.createBySuccess(shopMenuVOList);
    }



    public List<ShopMenuVO> converList(List<ShopMenu> sourceList,List<ShopMenuVO>targetList){
        if(sourceList!= null){
            for(ShopMenu shopMenu: sourceList){
                targetList.add(mapper.map(shopMenu,ShopMenuVO.class));
            }
        }
        return targetList;
    }


}

