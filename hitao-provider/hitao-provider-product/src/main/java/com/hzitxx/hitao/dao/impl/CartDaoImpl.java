package com.hzitxx.hitao.dao.impl;

import com.hzitxx.hitao.dao.CartDao;
import com.hzitxx.hitao.entity.ShopGoodsCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {

    @Autowired
    private  RedisTemplate redisTemplate;

    @Override
    public boolean addCart(int memberId,ShopGoodsCart shopGoodsCart) {
        HashOperations<byte[],Integer,ShopGoodsCart> hashOperations = this.redisTemplate.opsForHash();
        try{
            //判断是否存在该数据,如果存在则修改,否则添加
            byte[] keyName = ("memberId:"+memberId).getBytes();
            ShopGoodsCart goodsCart = hashOperations.get(keyName,shopGoodsCart.getGoodsId());//
            if(goodsCart != null){
                //存在，则修改数量
                shopGoodsCart.setNumber(shopGoodsCart.getNumber()+goodsCart.getNumber());
            }
            hashOperations.put(keyName,
                    shopGoodsCart.getGoodsId(),shopGoodsCart);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除购物车信息
     * @param memberId
     * @param goodsIds
     * @return
     */
    @Override
    public boolean deleteCart(int memberId, Long[] goodsIds) {
        HashOperations<byte[],Integer,ShopGoodsCart> hashOperations = this.redisTemplate.opsForHash();
        Long result= hashOperations.delete(("memberId:"+memberId).getBytes(),goodsIds);
        return result > 0;
    }

    /**
     * 获取购物车信息
     * @return
     */
    @Override
    public List<ShopGoodsCart> cartList(int memberId) {
        HashOperations<byte[],Integer,ShopGoodsCart> hashOperations = this.redisTemplate.opsForHash();
        return hashOperations.values(("memberId:"+memberId).getBytes());
    }

    /**
     * 编辑购物车信息
     * @param memberId
     * @param shopGoodsCart
     * @return
     */
    @Override
    public boolean update(int memberId, ShopGoodsCart shopGoodsCart) {
        HashOperations<byte[],Integer,ShopGoodsCart> hashOperations = this.redisTemplate.opsForHash();
        ShopGoodsCart goodsCart = hashOperations.get(("memberId:"+memberId).getBytes(),shopGoodsCart.getGoodsId());
        if(goodsCart == null){
            return false;
        }
        goodsCart.setNumber(shopGoodsCart.getNumber());
        try{
            hashOperations.put(("memberId:"+memberId).getBytes(),goodsCart.getGoodsId(),goodsCart);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 获取会员的购物车商品数量
     * @param memberId
     * @return
     */
    @Override
    public long cartCount(int memberId) {
        HashOperations<byte[],Integer,ShopGoodsCart> hashOperations = this.redisTemplate.opsForHash();
        return hashOperations.size(("memberId:"+memberId).getBytes());
    }
}
