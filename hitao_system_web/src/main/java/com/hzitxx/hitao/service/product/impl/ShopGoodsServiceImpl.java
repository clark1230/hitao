package com.hzitxx.hitao.service.product.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.vo.shopGoods.ShopGoodsCateVO;
import com.hzitxx.hitao.vo.shopGoods.ShopGoodsVO;
import com.hzitxx.hitao.mapper.product.ShopGoodsAttrMapper;
import com.hzitxx.hitao.mapper.product.ShopGoodsContentMapper;
import com.hzitxx.hitao.mapper.product.ShopGoodsMapper;
import com.hzitxx.hitao.service.product.IShopGoodsService;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsAttr;
import com.hzitxx.hitao.system.pojo.product.ShopGoodsContent;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-02
 */
@Service
public class ShopGoodsServiceImpl implements IShopGoodsService {

    @Autowired(required = false)
    private ShopGoodsMapper mapper;


    @Autowired(required = false)
    private ShopGoodsAttrMapper attrMapper;

    @Autowired(required =  false)
    private ShopGoodsContentMapper goodsContentMapper;


    @Override
    public ServerResponse addShopGoods(ShopGoods shopGoods){
        int result = this.mapper.addShopGoods(shopGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息添加成功!");
    }

    /**
     * 添加商品信息
     * @param shopGoodsVO
     * @return
     */
    @Transactional
    @Override
    public ServerResponse addShopGoodsSelective(ShopGoodsVO shopGoodsVO){
        ShopGoods shopGoods = new ShopGoods();
        shopGoods.setCreatedTime(new Date());
        BeanUtils.copyProperties(shopGoodsVO,shopGoods);
        // 添加商品信息
        int result = this.mapper.addShopGoodsSelective(shopGoods);
        if(result == 0){
            return ServerResponse.createByErrorMessage("商品信息添加失败!");
        }else{
            // 添加商品内容
            ShopGoodsContent shopGoodsContent = new ShopGoodsContent();
            BeanUtils.copyProperties(shopGoodsVO,shopGoodsContent);
            shopGoodsContent.setCreatedTime(new Date());
            shopGoodsContent.setGoodsId(shopGoods.getGoodsId());
            this.goodsContentMapper.addShopGoodsContentSelective(shopGoodsContent);
            // 添加商品属性
            ShopGoodsAttr shopGoodsAttr = new ShopGoodsAttr();
            shopGoodsAttr.setCreatedTime(new Date());
            shopGoodsAttr.setGoodsId(shopGoods.getGoodsId());
            shopGoodsAttr.setAttrValue(JSON.toJSONString(shopGoodsVO.getAttrValue()));
            shopGoodsAttr.setCatId(shopGoodsVO.getGcId());
            this.attrMapper.addShopGoodsAttrSelective(shopGoodsAttr);
        }
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息添加失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息添加成功!");
    }

    @Override
    public ServerResponse deleteById(int goodsId){
         int result = this.mapper.deleteById(goodsId);
         if(result != 1){
             return  ServerResponse.createByErrorMessage("商品信息删除失败!");
         }
         return ServerResponse.createBySuccessMessage("商品信息添加成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result == 0){
            return ServerResponse.createByErrorMessage("商品信息批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(ShopGoods shopGoods){
        int result =  this.mapper.updateById(shopGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("商品信息修改失败!");
        }
        return ServerResponse.createBySuccessMessage("商品信息修改成功!");
    }

    /**
     * 编辑商品信息
     * @param shopGoodsVO
     * @return
     */
    @Transactional
    @Override
    public  ServerResponse updateSelectiveById(ShopGoodsVO shopGoodsVO){

        int goodsId = shopGoodsVO.getGoodsId();
        ShopGoods shopGoods = new ShopGoods();
        BeanUtils.copyProperties(shopGoods,shopGoodsVO);
        shopGoods.setUpdatedTime(new Date());


        ShopGoodsAttr shopGoodsAttr = new ShopGoodsAttr();
        shopGoodsAttr.setGoodsId(goodsId);
        shopGoodsAttr.setAttrValue(JSON.toJSONString(shopGoodsVO.getAttrValue()));
        shopGoodsAttr.setUpdatedTiime(new Date());


        ShopGoodsContent shopGoodsContent = new ShopGoodsContent();
        shopGoodsContent.setGoodsId(goodsId);
        shopGoodsContent.setContent(shopGoodsVO.getContent());
        shopGoodsContent.setUpdatedTime(new Date());
        try{
            // 保存商品基本信息
            this.mapper.updateSelectiveById(shopGoods);
            // 保存商品属性
            this.goodsContentMapper.updateSelectiveById(shopGoodsContent);
            // 保存商品内容
            this.attrMapper.updateSelectiveById(shopGoodsAttr);
            return ServerResponse.createBySuccessMessage("商品信息修改成功!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ServerResponse.createByErrorMessage("商品信息编辑失败!");
    }

    @Override
    public  ServerResponse searchShopGoods(Map<String, Object> map){
        List<ShopGoods> shopGoods = this.mapper.searchShopGoods(map);
        return ServerResponse.createBySuccess(shopGoods);
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ShopGoods>> page(int page, int limit, Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ShopGoods>  obj=mapper.searchShopGoods(map);
        PageInfo<ShopGoods> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ShopGoods> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param goodsId
     * @return
     */
    @Override
    public ServerResponse findOne(Integer goodsId){
        // 查询商品信息
        ShopGoods shopGoods = this.mapper.findOne(goodsId);
        if(shopGoods == null){
            return ServerResponse.createByErrorMessage("该商品不存在!");
        }
        // 查询商品图片

        // 查询商品内容
        ShopGoodsContent shopGoodsContent = this.goodsContentMapper.findOne(goodsId);
        // 查询商品属性
        ShopGoodsAttr shopGoodsAttr = attrMapper.findOne(goodsId);

        ShopGoodsVO shopGoodsVO = new ShopGoodsVO();
        BeanUtils.copyProperties(shopGoods,shopGoodsVO);
        // json反序列化
        shopGoodsVO.setAttrValue(JSON.parseArray(shopGoodsAttr.getAttrValue(), ShopGoodsCateVO.class));
        shopGoodsVO.setContent(shopGoodsContent.getContent());

        if(shopGoods == null){
            return ServerResponse.createByErrorMessage("该数据不存在!");
        }
        return ServerResponse.createBySuccess(shopGoodsVO);
     }
}

