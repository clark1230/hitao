package com.hzitxx.hitao.service.gateway.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.gateway.GatewayApiDefineMapper;
import com.hzitxx.hitao.service.gateway.IGatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import com.hzitxx.hitao.util.LayuiEntity;
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
 * @since 2018-06-07
 */
@Service
public class GatewayApiDefineServiceImpl implements IGatewayApiDefineService {

    @Autowired(required = false)
    private GatewayApiDefineMapper mapper;

    @Override
    public ServerResponse addGatewayApiDefine(GatewayApiDefine gatewayApiDefine){
        int result = this.mapper.addGatewayApiDefine(gatewayApiDefine);
        if(result != 1){
            return  ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addGatewayApiDefineSelective(GatewayApiDefine gatewayApiDefine){
        int result = this.mapper.addGatewayApiDefineSelective(gatewayApiDefine);
        if(result !=1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int id){
        int result = this.mapper.deleteById(id);
        if(result == 0){
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
    public  ServerResponse updateById(GatewayApiDefine gatewayApiDefine){
        int result = this.mapper.updateById(gatewayApiDefine);
        if(result != 1){
            return ServerResponse.createByErrorMessage("修改失败!");
        }
        return ServerResponse.createBySuccessMessage("修改成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(GatewayApiDefine gatewayApiDefine){
        int result = this.mapper.updateSelectiveById(gatewayApiDefine);
        if(result != 1){
            return ServerResponse.createByErrorMessage("修改失败!");
        }
        return ServerResponse.createBySuccessMessage("修改成功!");
    }

    @Override
    public  ServerResponse<List<GatewayApiDefine>> searchGatewayApiDefine(Map<String, Object> map){
        List<GatewayApiDefine> gatewayApiDefines = this.mapper.searchGatewayApiDefine(map);
        if(gatewayApiDefines.size() == 0){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(gatewayApiDefines);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<GatewayApiDefine>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<GatewayApiDefine>  obj=mapper.searchGatewayApiDefine(map);
        PageInfo<GatewayApiDefine> pageInfo=new PageInfo<>(obj);
        LayuiEntity<GatewayApiDefine> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public ServerResponse findOne(Integer id){
        GatewayApiDefine gatewayApiDefine = this.mapper.findOne(id);
        if(gatewayApiDefine == null){
            return ServerResponse.createByErrorMessage("该数据不存在!");
        }
        return ServerResponse.createBySuccess(gatewayApiDefine);
     }
}

