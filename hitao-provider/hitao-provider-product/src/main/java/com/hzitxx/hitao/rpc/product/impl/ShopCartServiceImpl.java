package com.hzitxx.hitao.rpc.product.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.dao.CartDao;
import com.hzitxx.hitao.front.product.ShopGoods;
import com.hzitxx.hitao.entity.ShopGoodsCart;
import com.hzitxx.hitao.mapper.ShopGoodsMapper;
import com.hzitxx.hitao.rpc.member.MemberService;
import com.hzitxx.hitao.rpc.product.ShopCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import  java.util.Map;
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ShopGoodsMapper goodsMapper;

    /**
     * 添加商品到购物车中
     * @param memberId
     * @param shopGoodsCart
     * @return
     */
    @Override
    public ServerResponse addCart(int memberId,ShopGoodsCart shopGoodsCart) {
        //检查该用户是否存在(调用用户微服务)
        ServerResponse serverResponse = this.memberService.checkUserExists(memberId);
        if(!serverResponse.isSuccess()){
          return ServerResponse.createByErrorMessage("该用户不存在!");
        }
        //查询商品信息
        ShopGoods shopGoods = this.goodsMapper.findOne(shopGoodsCart.getGoodsId());
        if(shopGoods == null){
            return ServerResponse.createByErrorMessage("该商品不存在!");
        }
        BeanUtils.copyProperties(shopGoods,shopGoodsCart);//拷贝属性
        //将商品添加到购物车中
        boolean result = this.cartDao.addCart(memberId,shopGoodsCart);
        if(!result){
            return ServerResponse.createByErrorMessage("商品未能到购物车中!");
        }
        return ServerResponse.createBySuccess("该商品已经添加到购物车中!",this.cartDao.cartCount(memberId));
    }

    /**
     * 删除购物车信息
     * @param memberId
     * @param goodsIds
     * @return
     */
    @Override
    public ServerResponse deleteCart(int memberId, Long[] goodsIds) {
        //检查用户是否存在
        ServerResponse serverResponse = this.memberService.checkUserExists(memberId);
        if(!serverResponse.isSuccess()){
            return  ServerResponse.createByErrorMessage("该用户不存在!");
        }
        boolean result = this.cartDao.deleteCart(memberId,goodsIds);
        if(!result){
            return ServerResponse.createByErrorMessage("购物车信息删除失败!");
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("cartList",this.cartDao.cartList(memberId));
        resultMap.put("cartCount",this.cartDao.cartCount(memberId));
        return ServerResponse.createBySuccess("购物车信息删除成功!",resultMap);
    }

    /**
     * 获取购物车信息
     * @param memberId
     * @return
     */
    @Override
    public ServerResponse cartList(int memberId) {
        List<ShopGoodsCart>  shopGoodsCartList = this.cartDao.cartList(memberId);
        if(shopGoodsCartList != null && shopGoodsCartList.size() ==0){
            return ServerResponse.createByErrorMessage("暂无购物车信息!");
        }
        return ServerResponse.createBySuccess(shopGoodsCartList);
    }

    /**
     * 获取会员购物商品数量
     * @param memberId
     * @return
     */
    @Override
    public ServerResponse cartCount(int memberId) {
        long size = this.cartDao.cartCount(memberId);
        if(size == 0){
            return ServerResponse.createByErrorMessage("去添加点什么吧!");
        }
        return ServerResponse.createBySuccess(size);
    }

    /**
     * 编辑购物车信息
     * @param memberId
     * @param shopGoodsCart
     * @return
     */
    @Override
    public ServerResponse update(int memberId, ShopGoodsCart shopGoodsCart) {
        boolean result = this.cartDao.update(memberId,shopGoodsCart);
        if(!result){
            return ServerResponse.createByErrorMessage("修改失败!");
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("cartList",this.cartDao.cartList(memberId));
        resultMap.put("cartCount",this.cartDao.cartCount(memberId));
        return ServerResponse.createBySuccess("修改成功!",resultMap);
    }
}
