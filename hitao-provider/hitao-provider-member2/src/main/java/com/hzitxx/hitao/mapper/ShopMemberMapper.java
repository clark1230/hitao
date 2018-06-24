package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.ShopMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-18
 */
public interface ShopMemberMapper {

    int addShopMember(ShopMember obj);

    int addShopMemberSelective(ShopMember obj);

    int deleteById(int memberId);
                                                                                                                        
    int deleteByIds(String[] ids);

    int updateById(ShopMember shopMember);

    int updateSelectiveById(ShopMember shopMember);

    ShopMember findOne(Integer memberId);
                                                                                                                        
    List<ShopMember> searchShopMember(@Param("map") Map<String, Object> map);

    /**
     * 检查会员名是否存在
     * @param memberName
     * @return
     */
    int checkMember(String memberName);

    /**
     * 会员登录
     * @param shopMember
     * @return
     */
    ShopMember login(ShopMember shopMember);
}