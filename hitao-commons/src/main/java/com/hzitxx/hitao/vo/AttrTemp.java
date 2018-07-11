package com.hzitxx.hitao.vo;

import java.util.List;

public class AttrTemp {
    private Integer catId;
    private List<ShopGoodsGroupAttr> attrTemp;
    public AttrTemp(){

    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public List<ShopGoodsGroupAttr> getAttrTemp() {
        return attrTemp;
    }

    public void setAttrTemp(List<ShopGoodsGroupAttr> attrTemp) {
        this.attrTemp = attrTemp;
    }

    @Override
    public String toString() {
        return "AttrTemp{" +
                "catId=" + catId +
                ", attrTemp='" + attrTemp + '\'' +
                '}';
    }
}
