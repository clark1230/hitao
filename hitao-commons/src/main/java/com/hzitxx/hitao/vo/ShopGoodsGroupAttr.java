package com.hzitxx.hitao.vo;

import java.util.List;

public class ShopGoodsGroupAttr {
    /**
     * 属性组名称
     */
    private String groupName;

    private List<ShopGoodsAttr> attrArr;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ShopGoodsAttr> getAttrArr() {
        return attrArr;
    }

    public void setAttrArr(List<ShopGoodsAttr> attrArr) {
        this.attrArr = attrArr;
    }
}
