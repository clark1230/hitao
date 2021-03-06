package com.hzitxx.hitao.controller.product;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopGoodsService;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import com.hzitxx.hitao.util.LayuiEntity;
import com.hzitxx.hitao.vo.shopgoods.ShopGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-02
 */
@RestController
@RequestMapping("/shopGoods")
public class ShopGoodsController  {

    @Autowired
    private IShopGoodsService shopGoodsService;


    /**
     * 分页
     * @return
     */
    @GetMapping(value="shopGoodsAjax")
    public ServerResponse<LayuiEntity<ShopGoods>> shopGoodsAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                @RequestParam(value = "limit",defaultValue = "20")
                                                        int  limit, String goodsName){
        Map<String,Object>  map = new HashMap<>();
        if(!StringUtils.isEmpty(goodsName)) {
            map.put("goodsName",goodsName);
        }
        return shopGoodsService.page(page,limit,map);

    }



    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "save")
    public ServerResponse save(@RequestBody ShopGoodsVO shopGoods){
       return shopGoodsService.addShopGoodsSelective(shopGoods);
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("update")
    public ServerResponse update(@RequestBody ShopGoodsVO shopGoodsVO){
        return  shopGoodsService.updateSelectiveById(shopGoodsVO);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
       return shopGoodsService.deleteByIds(ids);
    }

    /**
     * 根据商品编号查询商品信息
     * @param goodsId
     * @return
     */
    @GetMapping("findOne")
    public ServerResponse findOne(Integer goodsId){
        return this.shopGoodsService.findOne(goodsId);
    }

    /**
     * 商品上架或者下架
     * @return
     */
    @GetMapping("/onSalceOrShelves")
    public ServerResponse onSalceOrShelves(ShopGoods shopGoods) {
        return this.shopGoodsService.onSalceOrShelves(shopGoods);
    }
}
