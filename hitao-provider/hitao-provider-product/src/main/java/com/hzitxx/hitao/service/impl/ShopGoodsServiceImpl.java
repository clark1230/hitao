package com.hzitxx.hitao.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.product.ShopGoods;
import com.hzitxx.hitao.front.product.ShopGoodsAttr;
import com.hzitxx.hitao.front.product.ShopGoodsContent;
import com.hzitxx.hitao.front.product.vo.GoodsDetailVo;
import com.hzitxx.hitao.front.product.vo.GroupAttrVo;
import com.hzitxx.hitao.mapper.ShopGoodsAttrMapper;
import com.hzitxx.hitao.mapper.ShopGoodsContentMapper;
import com.hzitxx.hitao.mapper.ShopGoodsMapper;
import com.hzitxx.hitao.rpc.member.ShopFavoritesService;
import com.hzitxx.hitao.service.ShopGoodsService;
import com.hzitxx.hitao.system.pojo.product.ShopFavorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopGoodsServiceImpl implements ShopGoodsService {
    @Autowired(required = false)
    private ShopGoodsMapper goodsMapper;

    @Autowired(required = false)
    private ShopGoodsAttrMapper goodsAttrMapper;

    @Autowired(required = false)
    private ShopGoodsContentMapper goodsContentMapper;

    @Autowired(required = false)
    private ShopFavoritesService shopFavoritesService;

    /**
     * 获取商品信息
     * @return
     */
    @Override
    public ServerResponse findGoods() {
        List<ShopGoods> shopGoodsList = this.goodsMapper.findGoods();
        if(shopGoodsList == null){
            return ServerResponse.createByErrorMessage("获取商品信息失败!");
        }
        return ServerResponse.createBySuccess(shopGoodsList);
    }

    /**
     * 查询商品信息
     * @param goodsId
     * @return
     */
    @Override
    public ServerResponse findOne(int goodsId,Integer memberId) {
        ShopGoods shopGoods = this.goodsMapper.findOne(goodsId);
        //组装数据
        GoodsDetailVo detailVo = new GoodsDetailVo();
        detailVo.setShopGoods(shopGoods);
        //获取商品属性
        ShopGoodsAttr shopGoodsAttr = this.goodsAttrMapper.findOne(goodsId);
        List<GroupAttrVo> groupAttrVos = null;
        if(shopGoodsAttr != null){
            //反序列化 把数据库的json数据，反序列化为java对象
            groupAttrVos = JSONArray.parseArray(shopGoodsAttr.getAttrValue(), GroupAttrVo.class);
        }
        //商品内容
        ShopGoodsContent shopGoodsContent = this.goodsContentMapper.findOne(goodsId);
        if(shopGoodsContent != null){
            detailVo.setGoodsContent(shopGoodsContent);
        }
        detailVo.setGoodsAttr(groupAttrVos);

        ShopFavorites shopFavorites = null;
        if (memberId != null && !Integer.valueOf(0).equals(memberId)) {
            shopFavorites = this.shopFavoritesService.checkFavorites(memberId,goodsId).getData();
        }
        detailVo.setIsFavorites((shopFavorites==null)?0:1);
        if(shopGoods == null){
            return ServerResponse.createByErrorMessage("查询商品信息失败!");
        }
        return ServerResponse.createBySuccess(detailVo);
    }

    @Override
    public ServerResponse<ShopGoods> findById(Integer goodsId) {
        ShopGoods shopGoods = this.goodsMapper.findOne(goodsId);
        if(shopGoods == null){
            return  ServerResponse.createByErrorMessage("获取商品信息失败!");
        }
        return ServerResponse.createBySuccess(shopGoods);
    }


    /**
     * 库存的检查
     * @param goodsId
     * @return
     */
    @Override
    public ServerResponse checkout(int goodsId,int number) {
        int goodsStorage = this.goodsMapper.checkout(goodsId);
        if(goodsStorage < number ){
            return ServerResponse.createByErrorMessage("库存不足!");
        }
        return ServerResponse.createBySuccessMessage("库存充裕!");
    }

    /**
     * 查询所有非逻辑删除的商品数量
     * @return
     */
    @Override
    public ServerResponse goodsCount() {
        int result = this.goodsMapper.goodsCount();
        if(result == 0){
            return ServerResponse.createByErrorMessage("查询失败!");
        }
        return ServerResponse.createBySuccess(result);
    }
}
