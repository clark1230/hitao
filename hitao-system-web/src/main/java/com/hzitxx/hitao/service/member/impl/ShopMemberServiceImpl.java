package com.hzitxx.hitao.service.member.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.member.ShopMemberMapper;
import com.hzitxx.hitao.service.member.IShopMemberService;
import com.hzitxx.hitao.system.pojo.member.ShopMember;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
@Service
public class ShopMemberServiceImpl implements IShopMemberService {

    @Autowired
    private ShopMemberMapper memberMapper;

    @Override
    public ServerResponse addShopMember(ShopMember shopMember){
        int result =  this.memberMapper.addShopMember(shopMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addShopMemberSelective(ShopMember shopMember){
        int result =  this.memberMapper.addShopMemberSelective(shopMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int memberId){
        int result = this.memberMapper.deleteById(memberId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.memberMapper.deleteByIds(ids);
        if(result != 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopMember shopMember){
        int result = this.memberMapper.updateById(shopMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopMember shopMember){
        int result = this.memberMapper.updateSelectiveById(shopMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse<List<ShopMember>> searchShopMember(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.memberMapper.searchShopMember(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopMember>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopMember>  obj= memberMapper.searchShopMember(map);
        PageInfo<ShopMember> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopMember> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param memberId
     * @return
     */
    @Override
    public ServerResponse<ShopMember> findOne(Integer memberId){
        ShopMember shopMember = this.memberMapper.findOne(memberId);
        if(shopMember == null){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(shopMember);
     }
}

