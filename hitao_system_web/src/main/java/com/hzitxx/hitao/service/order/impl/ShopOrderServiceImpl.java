package com.hzitxx.hitao.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.order.ShopOrderMapper;
import com.hzitxx.hitao.service.order.IShopOrderService;
import com.hzitxx.hitao.system.pojo.order.ShopOrder;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 * @author xianyaoji
 * @since 2018-10-19
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService {

    @Autowired
    private ShopOrderMapper orderMapper;

    @Override
    public ServerResponse addShopOrder(ShopOrder shopOrder){
        int result = this.orderMapper.addShopOrder(shopOrder);
        if(result == 0) {
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopOrderSelective(ShopOrder shopOrder){
        int result = orderMapper.addShopOrderSelective(shopOrder);
        if(result == 0) {
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int orderId){
        int result = orderMapper.deleteById(orderId);
        if(result == 0) {
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = orderMapper.deleteByIds(ids);
        if(result == 0) {
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopOrder shopOrder){
        int result = orderMapper.updateById(shopOrder);
        if(result == 0) {
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopOrder shopOrder){
        int result = orderMapper.updateSelectiveById(shopOrder);
        if(result == 0) {
            return ServerResponse.createBySuccessMessage("编辑失败");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse<List<ShopOrder>> searchShopOrder(Map<String, Object> map){
        return ServerResponse.createBySuccess(orderMapper.searchShopOrder(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopOrder>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopOrder>  obj= orderMapper.searchShopOrder(map);
        PageInfo<ShopOrder> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopOrder> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param orderId
     * @return
     */
    @Override
    public ServerResponse<ShopOrder> findOne(Integer orderId){
        ShopOrder shopOrder = this.orderMapper.findOne(orderId);
        if(shopOrder == null) {
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccessMessage("查询成功!");
     }
}

