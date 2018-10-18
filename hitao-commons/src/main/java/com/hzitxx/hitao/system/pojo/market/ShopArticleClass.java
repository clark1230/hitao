package com.hzitxx.hitao.system.pojo.market;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 文章分类表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
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

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }
 
    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }
 
    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }
 
    public Integer getAcParentId() {
        return acParentId;
    }

    public void setAcParentId(Integer acParentId) {
        this.acParentId = acParentId;
    }
 
    public Integer getAcSort() {
        return acSort;
    }

    public void setAcSort(Integer acSort) {
        this.acSort = acSort;
    }
 
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
 
    public Integer getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(Integer acStatus) {
        this.acStatus = acStatus;
    }
 
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
 
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
 


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