package com.hzitxx.hitao.service.product.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.mapper.product.ShopGoodsAttrTemplateMapper;
import com.hzitxx.hitao.service.product.IShopGoodsAttrTemplateService;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttrTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性模板表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
@Service
public class ShopGoodsAttrTemplateServiceImpl implements IShopGoodsAttrTemplateService {

    @Autowired(required = false)
    private ShopGoodsAttrTemplateMapper mapper;

    @Override
    public ServerResponse addShopGoodsAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate){
        int result =  this.mapper.addShopGoodsAttrTemplate(shopGoodsAttrTemplate);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    /**
     * 添加商品属性
     * @param shopGoodsAttrTemplate
     * @return
     */
    @Override
    public ServerResponse addShopGoodsAttrTemplateSelective(ShopGoodsAttrTemplate shopGoodsAttrTemplate){
        // 检查是否存在该属性模板
        ShopGoodsAttrTemplate attrTemplate = this.mapper.findByCatId(shopGoodsAttrTemplate.getCatId());
        int result = 0;
        if(attrTemplate == null){
            // 新增
            result =  this.mapper.addShopGoodsAttrTemplateSelective(shopGoodsAttrTemplate);
        }else{
            // 编辑
            result =  this.mapper.updateSelectiveByCatId(shopGoodsAttrTemplate);
        }
        if(result != 1){
            return ServerResponse.createByErrorMessage("操作失败!");
        }
        return ServerResponse.createBySuccessMessage("操作成功!");
    }

    @Override
    public ServerResponse deleteById(int attrId){
        int result = this.mapper.deleteById(attrId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result != 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopGoodsAttrTemplate shopGoodsAttrTemplate){
        int result = this.mapper.updateById(shopGoodsAttrTemplate);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ShopGoodsAttrTemplate shopGoodsAttrTemplate){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(shopGoodsAttrTemplate));
    }

    @Override
    public  ServerResponse<List<ShopGoodsAttrTemplate>> searchShopGoodsAttrTemplate(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchShopGoodsAttrTemplate(map));
    }


    /**
     * 根据id查询数据
     * @param attrId
     * @return
     */
    @Override
    public ServerResponse<ShopGoodsAttrTemplate> findOne(Integer attrId){
        ShopGoodsAttrTemplate shopGoodsAttrTemplate = this.mapper.findOne(attrId);
        if(shopGoodsAttrTemplate == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(shopGoodsAttrTemplate);
     }

    @Override
    public ServerResponse findByCatId(Integer catId) {
        ShopGoodsAttrTemplate attrTemplate = this.mapper.findByCatId(catId);
        if(attrTemplate == null){
            return ServerResponse.createByErrorMessage("去添加点什么吧!");
        }
        return ServerResponse.createBySuccess(attrTemplate.getAttrValue());
    }
}

