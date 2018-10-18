package com.hzitxx.hitao.service.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.member.ShopMember;
import com.hzitxx.hitao.util.LayuiEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */

public interface IShopMemberService  {
    ServerResponse addShopMember(ShopMember shopMember);

    ServerResponse addShopMemberSelective(ShopMember obj);

    ServerResponse deleteById(int memberId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ShopMember shopMember);

    ServerResponse updateSelectiveById(ShopMember shopMember);

    ServerResponse<List<ShopMember>> searchShopMember(Map<String, Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ShopMember>> page(int page, int limit, Map<String, Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ShopMember> findOne(Integer memberId);

}
