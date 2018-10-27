package com.hzitxx.hitao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-20
 */
@Data
public class ShopMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Integer mId;
    /**
     * 菜单名
     */
    private String mName;
    /**
     * url路径
     */
    private String mUrl;
    /**
     * 父级ID
     */
    private Integer mParentId;
    /**
     * 排序
     */
    private Integer mSort;
    /**
     * 菜单等级
     */
    private Integer mLevel;
    /**
     * 菜单ID路径
     */
    private String mPath;
    /**
     * 描述
     */
    private String mDescription;
    /**
     * 录入人
     */
    private Integer createdBy;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private Integer updatedBy;
    /**
     * 修改时间
     */
    private Date updatedTime;

    private Integer isDel;

    private List<ShopMenu> children = new ArrayList<>();

    @Override
    public String toString() {
        return "ShopMenu{" +
        "mId=" + mId +
        ", mName=" + mName +
        ", mUrl=" + mUrl +
        ", mParentId=" + mParentId +
        ", mSort=" + mSort +
        ", mLevel=" + mLevel +
        ", mPath=" + mPath +
        ", mDescription=" + mDescription +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        "}";
    }
}