package com.hzitxx.hitao.entity;

import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文章分类表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-11
 */
@Data
public class ShopArticleClass implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 索引ID
     */
    private Integer acId;
    /**
     * 分类标识码
     */
    private String acCode;
    /**
     * 分类名称
     */
    private String acName;
    /**
     * 父ID
     */
    private Integer acParentId;
    /**
     * 排序
     */
    private Integer acSort;
    /**
     * 是否删除,0 不删除 1删除  默认为0
     */
    private Integer isDel;
    /**
     * 分类状态0:启用;1:停用
     */
    private Integer acStatus;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;

    @Override
    public String toString() {
        return "ShopArticleClass{" +
        "acId=" + acId +
        ", acCode=" + acCode +
        ", acName=" + acName +
        ", acParentId=" + acParentId +
        ", acSort=" + acSort +
        ", isDel=" + isDel +
        ", acStatus=" + acStatus +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}