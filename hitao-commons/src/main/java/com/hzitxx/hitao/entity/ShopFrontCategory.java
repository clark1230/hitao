package com.hzitxx.hitao.entity;

import lombok.Data;

import  java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-07
 */
@Data
public class ShopFrontCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 类目编号
     */
    private Integer frontCatId;
    /**
     * 后台类目编号
     */
    private Integer catId;
    /**
     * 类目名称
     */
    private String catName;
    /**
     * 类目级别
     */
    private int level;
    /**
     * 父级类目
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 分类图标
     */
    private String iconImage;
    /**
     * 地址
     */
    private String url;
    /**
     * 广告图
     */
    private String advImage;
    /**
     * 广告链接
     */
    private String advLink;


    @Override
    public String toString() {
        return "ShopFrontCategory{" +
        "catId=" + catId +
        ", catName=" + catName +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", iconImage=" + iconImage +
        ", url=" + url +
        ", advImage=" + advImage +
        ", advLink=" + advLink +
        "}";
    }
}