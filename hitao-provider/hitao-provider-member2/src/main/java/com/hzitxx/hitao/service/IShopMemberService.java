package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.vo.shopmember.ShopMemberVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-18
 */

public interface IShopMemberService {

    /**
     * 会员登录
     * @param shopMember
     * @return
     */
    ServerResponse login(ShopMember shopMember);

    /**
     * 会员注册
     * @param shopMemberVO
     * @return
     */
    ServerResponse register(ShopMemberVO shopMemberVO);

    /**
     * 发送短信验证吗
     * @param memberMobile
     * @return
     */
    ServerResponse sendIdentifyingCode(String memberMobile);

    /**
     * 校验短信验证码
     * @param memberMobile
     * @param code
     * @return
     */
    ServerResponse checkIdentifyingCode(String memberMobile,Integer code);

    int deleteById(int memberId);

    int deleteByIds(String[] ids);

    int updateById(ShopMember shopMember);

    ServerResponse<String> updateSelectiveById(ShopMember shopMember);

    List<ShopMember> searchShopMember(Map<String, Object> map);


    /**
     * 根据编号查询数据
     *
     */
    ServerResponse findOne(Integer memberId);

}
