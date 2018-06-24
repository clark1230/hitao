package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.mapper.ShopMemberMapper;
import com.hzitxx.hitao.pojo.MemberInfo;
import com.hzitxx.hitao.service.IShopMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-18
 */
@Service
public class ShopMemberServiceImpl implements IShopMemberService {

    @Autowired
    private ShopMemberMapper mapper;

    @Autowired
    private Audience audience;

    @Override
    public int addShopMember(ShopMember shopMember){
        return mapper.addShopMember(shopMember);
    }

    @Override
    public ServerResponse login(ShopMember shopMember) {
        shopMember = this.mapper.login(shopMember);
        if(shopMember == null){
            return ServerResponse.createByErrorMessage("登陆失败!用户名或者密码错误!");
        }
        String jwtToken = JwtHelper.createJWT(shopMember.getMemberName(),
                shopMember.getMemberId()+"",
                "member",//暂时写死
                audience.getClientId(),
                audience.getName(),
                audience.getExpiresSecond()*1000,//1000不能省略
                audience.getBase64Secret());
        shopMember.setMemberPassword(null);
        shopMember.setPasswordSalt(null);
        MemberInfo memberInfo = new MemberInfo(jwtToken,shopMember);
        return ServerResponse.createBySuccess("登陆成功!",memberInfo);
    }

    @Override
    public ServerResponse addShopMemberSelective(ShopMember shopMember){
        if(StringUtils.isEmpty(shopMember.getMemberName()) && StringUtils.isEmpty(shopMember.getMemberPassword())){
            return ServerResponse.createByErrorMessage("用户名或者密码不能为空!");
        }
        //检查用户名是否存在
        int result = this.mapper.checkMember(shopMember.getMemberName());
        if(result != 0){
            return  ServerResponse.createByErrorMessage("该会员名称已经存在，请使用其他名称!");
        }
        //添加
        result = this.mapper.addShopMemberSelective(shopMember);
        if(result == 0){
            return  ServerResponse.createByErrorMessage("注册失败!");
        }
        return ServerResponse.createBySuccess("注册成功!");
    }

    @Override
    public int deleteById(int memberId){
            return mapper.deleteById(memberId);
    }

    @Override
    public int deleteByIds(String[]ids){
        return mapper.deleteByIds(ids);
    }
    @Override
    public  int updateById(ShopMember shopMember){
        return mapper.updateById(shopMember);
    }

    /**
     * 编辑会员信息
     * @param shopMember
     * @return
     */
    @Override
    public  ServerResponse<String> updateSelectiveById(ShopMember shopMember){
        int result = this.mapper.updateSelectiveById(shopMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("会员信息编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("会员信息编辑成功!");
    }

    @Override
    public  List<ShopMember> searchShopMember(Map<String, Object> map){
        return mapper.searchShopMember(map);
    }



    /**
     * 根据id查询数据
     * @param memberId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer memberId){
        ShopMember shopMember = this.mapper.findOne(memberId);
        if(shopMember == null){
            return ServerResponse.createByErrorMessage("没有该用户!");
        }
        return ServerResponse.createBySuccess(shopMember);
     }
}

