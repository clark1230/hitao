package com.hzitxx.hitao.system.pojo.product;

import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-28
 */
@Data
public class ShopBrand implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 索引ID
     */
    private Integer brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 类别名称
     */
    private String brandClass;
    /**
     * 图片
     */
    private String brandPic;
    /**
     * 排序
     */
    private Integer brandSort;
    /**
     * 推荐，0为否，1为是，默认为0
     */
    private Integer brandRecommend;
    /**
     * 品牌申请，0为申请中，1为通过，默认为1，申请功能是会员使用，系统后台默认为1
     */
    private Integer brandApply;
    /**
     * 所属分类id
     */
    private Integer classId;
    /**
     * 是否删除0:未删除;1:已删除，默认为0
     */
    private Integer isDel;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 更新时间(自更新)
     */
    private Date updatedTime;


    @Override
    public String toString() {
        return "ShopBrand{" +
        "brandId=" + brandId +
        ", brandName=" + brandName +
        ", brandClass=" + brandClass +
        ", brandPic=" + brandPic +
        ", brandSort=" + brandSort +
        ", brandRecommend=" + brandRecommend +
        ", brandApply=" + brandApply +
        ", classId=" + classId +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}