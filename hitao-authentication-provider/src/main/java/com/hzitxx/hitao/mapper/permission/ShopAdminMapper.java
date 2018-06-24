package com.hzitxx.hitao.mapper.permission;

import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import com.hzitxx.hitao.vo.ShopAdminVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-15
 */
public interface ShopAdminMapper {

    int addShopAdmin(ShopAdmin obj);

    int addShopAdminSelective(ShopAdmin obj);

    int deleteById(int adminId);
                                        
    int deleteByIds(String[] ids);

    int updateById(ShopAdmin shopAdmin);

    int updateSelectiveById(ShopAdmin shopAdmin);

    ShopAdmin findOne(Integer adminId);
                                        
    List<ShopAdminVO> searchShopAdmin(@Param("map") Map<String, Object> map);

    /**
     * 系统登陆
     * @param shopAdmin
     * @return
     */
    ShopAdmin login(ShopAdmin shopAdmin);

    /**
     * 根据用户名登陆
     * @param adminName
     * @return
     */
    ShopAdmin loginByAdminName(String adminName);

    /**
     * 检查系统用户是否存在
     * @param adminName
     * @return
     */
    ShopAdmin checkAdminNameExists(String adminName);
}