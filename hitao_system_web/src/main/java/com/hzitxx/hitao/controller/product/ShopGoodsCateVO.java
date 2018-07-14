package com.hzitxx.hitao.controller.product;

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
