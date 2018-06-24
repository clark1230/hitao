package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopMember;

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

    int addShopMember(ShopMember shopMember);

    ServerResponse login(ShopMember shopMember);

    ServerResponse addShopMemberSelective(ShopMember obj);

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
