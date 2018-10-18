package com.hzitxx.hitao.system.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-13
 */
public class ShopDic implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 字典编号
     */
    private Integer dicId;
    /**
     * 字典名称
     */
    private String name;
    /**
     * 标识码
     */
    private String code;
    /**
     * 父级编号
     */
    private Integer parentId;
    /**
     * 状态, 0:已启用 1:已禁用 默认为:0
     */
    private Integer status;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 录入人
     */
    private Integer createdBy;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 修改人
     */
    private Integer updatedBy;

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
 
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
 
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
 
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
 
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
 
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
 
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
 


    @Override
    public String toString() {
        return "ShopDic{" +
        "dicId=" + dicId +
        ", name=" + name +
        ", code=" + code +
        ", parentId=" + parentId +
        ", status=" + status +
        ", createdTime=" + createdTime +
        ", createdBy=" + createdBy +
        ", updatedTime=" + updatedTime +
        ", updatedBy=" + updatedBy +
        "}";
    }
}