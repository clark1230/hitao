package com.hzitxx.hitao.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.jwt.Audience;
import com.hzitxx.hitao.jwt.JwtHelper;
import com.hzitxx.hitao.mapper.ShopAddressMapper;
import com.hzitxx.hitao.mapper.ShopMemberMapper;
import com.hzitxx.hitao.rpc.ShopCartService;
import com.hzitxx.hitao.service.IShopMemberService;
import com.hzitxx.hitao.utils.Md5Util;
import com.hzitxx.hitao.utils.MsgUtil;
import com.hzitxx.hitao.vo.shopmember.ShopMemberVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired(required =  false)
    private ShopMemberMapper memberMapper;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Audience audience;

    @Autowired
    private ShopCartService shopCartService;

    @Autowired(required = false)
    private ShopAddressMapper addressMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 系统登陆
     * @param shopMember
     * @return
     */
    @Override
    public ServerResponse login(ShopMember shopMember) {
        shopMember.setMemberTime(new Date());
        shopMember = this.memberMapper.login(shopMember);
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
        JSONObject jsonObject = new JSONObject();
        // token令牌
        jsonObject.put("token",jwtToken);
        // 会员信息
        jsonObject.put("shopMember",shopMember);
        // 购物车数量
        jsonObject.put("cartCount",this.shopCartService.cartCount(shopMember.getMemberId()).getData());// 获取购物车商品数量
        // 默认收货地址
        jsonObject.put("defaultAddress",addressMapper.searchDefaulAddress(shopMember.getMemberId())); // 获取会员的收货地址

        return ServerResponse.createBySuccess("登陆成功!",jsonObject);
    }

    /**
     * 会员注册
     * @param shopMemberVO
     * @return
     */
    @Override
    public ServerResponse register(ShopMemberVO shopMemberVO){
        // 判断参数
        if(StringUtils.isEmpty(shopMemberVO.getMemberName())
                &&( StringUtils.isEmpty(shopMemberVO.getMemberPassword())
                && StringUtils.isEmpty(shopMemberVO.getConfirmPassword()))){
            return ServerResponse.createByErrorMessage("用户名或者密码不能为空!");
        }
        // 判断密码是否需一致
        if(!shopMemberVO.getMemberPassword().equals(shopMemberVO.getConfirmPassword())){
            return ServerResponse.createByErrorMessage("两次密码不一致!");
        }
        //检查用户名是否存在
        int result = this.memberMapper.checkMember(shopMemberVO.getMemberName());
        if(result != 0){
            return  ServerResponse.createByErrorMessage("该会员名称已经存在，请使用其他名称!");
        }

        ShopMember shopMember = mapper.map(shopMemberVO,ShopMember.class);
        try {
            shopMember.setMemberPassword(Md5Util.getMD5(shopMember.getMemberPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //添加
        result = this.memberMapper.addShopMemberSelective(shopMember);
        if(result == 0){
            return  ServerResponse.createByErrorMessage("注册失败!");
        }
        return ServerResponse.createBySuccessMessage("注册成功!");
    }

    /**
     * 发送短信验证码
     * @param memberMobile
     * @return
     */
    @Override
    public ServerResponse sendIdentifyingCode(String memberMobile) {
        if(StringUtils.isEmpty(memberMobile)){
            return ServerResponse.createByErrorMessage("请输入手机号码!");
        }
        // ***********随机生成验证码 6位数的验证码**************
        int value = 100000+(int)(Math.random()*1000000);
        SendSmsResponse resp = null;
        try {
            resp = MsgUtil.sendMsg(memberMobile,value);
            System.out.println(resp.getCode()+"----"+resp.getMessage());
            System.out.println(value);
            if("OK".equalsIgnoreCase(resp.getCode())){
                // 保存到redis数据库中
                ValueOperations<String,Integer> valueOperations = redisTemplate.opsForValue();
                valueOperations.set(memberMobile,value,120, TimeUnit.SECONDS); // 120秒失效
                return ServerResponse.createBySuccessMessage("短信验证码发送成功!");
            }else{
                return ServerResponse.createByErrorMessage("短信验证码发送失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServerResponse.createByErrorMessage("短信验证码发送失败!");

    }

    /**
     * 校验短信验证码
     * @param memberMobile
     * @param code
     * @return
     */
    @Override
    public ServerResponse checkIdentifyingCode(String memberMobile, Integer code) {
        ValueOperations<String,Integer> valueOperations = redisTemplate.opsForValue();
        Integer checkCode = valueOperations.get(memberMobile);
        System.out.println(checkCode);
        if(checkCode==null || !checkCode.equals(code)){
            return ServerResponse.createByErrorMessage("短信验证码验证失败!");
        }
        return ServerResponse.createBySuccessMessage("短信验证验证通过!");
    }

    @Override
    public int deleteById(int memberId){
            return memberMapper.deleteById(memberId);
    }

    @Override
    public int deleteByIds(String[]ids){
        return memberMapper.deleteByIds(ids);
    }
    @Override
    public  int updateById(ShopMember shopMember){
        return memberMapper.updateById(shopMember);
    }

    /**
     * 编辑会员信息
     * @param shopMember
     * @return
     */
    @Override
    public  ServerResponse<String> updateSelectiveById(ShopMember shopMember){
        int result = this.memberMapper.updateSelectiveById(shopMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("会员信息编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("会员信息编辑成功!");
    }

    @Override
    public  List<ShopMember> searchShopMember(Map<String, Object> map){
        return memberMapper.searchShopMember(map);
    }



    /**
     * 根据id查询数据
     * @param memberId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer memberId){
        ShopMember shopMember = this.memberMapper.findOne(memberId);
        if(shopMember == null){
            return ServerResponse.createByErrorMessage("没有该用户!");
        }
        return ServerResponse.createBySuccess(shopMember);
     }
}

