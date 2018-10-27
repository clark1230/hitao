package com.hzitxx.hitao.mapper.member;


import com.hzitxx.hitao.system.pojo.member.ShopMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
public interface ShopMemberMapper{

    int addShopMember(ShopMember obj);

    int addShopMemberSelective(ShopMember obj);

    int deleteById(int memberId);
                                                                                                                        
    int deleteByIds(String[] ids);

    int updateById(ShopMember shopMember);

    int updateSelectiveById(ShopMember shopMember);

    ShopMember findOne(Integer memberId);
                                                                                                                        
    List<ShopMember> searchShopMember(@Param("map") Map<String, Object> map);
}