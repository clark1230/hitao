package com.hzitxx.hitao.front.product.vo;

import com.hzitxx.hitao.entity.ShopGoodsCategory;
import lombok.Data;

import java.util.List;
@Data
public class ShopGoodsCategoryVo {

    private int value; //类目
    private String label;//类目名称
    private List<ShopGoodsCategoryVo> children;  //子类目

    @Override
    public String toString() {
        return "ShopGoodsCategoryVo{" +
                "catId=" + value +
                ", catName='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
