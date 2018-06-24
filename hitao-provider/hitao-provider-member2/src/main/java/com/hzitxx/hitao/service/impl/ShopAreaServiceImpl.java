package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopArea;
import com.hzitxx.hitao.mapper.ShopAreaMapper;
import com.hzitxx.hitao.service.IShopAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-26
 */
@Service
public class ShopAreaServiceImpl implements IShopAreaService {

    @Autowired
    private ShopAreaMapper mapper;


    @Override
    public ServerResponse searchShopArea(Map<String, Object> map) {
        return ServerResponse.createBySuccess(this.mapper.searchShopArea(map));
    }
}

