package com.hzitxx.hitao.vo.shopgoods;

import lombok.Data;

import java.util.List;

@Data
public class ShopGoodsCateVO {
    /**
     * 属性组
     */
    private String group;

    private List<ShopGoodsValue> attrs;

}
