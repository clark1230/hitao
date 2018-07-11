package com.hzitxx.hitao.system.pojo.product;

import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品分类表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-05-03
 */
@Data
public class ShopGoodsCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Integer catId;
    /**
     * 分类名称
     */
    private String catName;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 分类图片
     */
    private String iconImage;
    /**
     * 分类级别
     */
    private Integer level;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否删除0:未删除;1:已删除,默认为0
     */
    private Integer isDel;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;


    @Override
    public String toString() {
        return "ShopGoodsCategory{" +
        "catId=" + catId +
        ", catName=" + catName +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", iconImage=" + iconImage +
        ", level=" + level +
        ", keywords=" + keywords +
        ", description=" + description +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}