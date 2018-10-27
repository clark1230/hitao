package com.hzitxx.hitao.front.product.vo;

import lombok.Data;

import java.util.List;
@Data
public class ShopGoodsCategoryVo {

    private int value; //类目

    private String label;//类目名称

    private Integer isDel;//是否删除

    private List<ShopGoodsCategoryVo> children;  //子类目

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ShopGoodsCategoryVo> getChildren() {
        return children;
    }

    public void setChildren(List<ShopGoodsCategoryVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ShopGoodsCategoryVo{" +
                "catId=" + value +
                ", catName='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
