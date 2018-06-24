package com.hzitxx.hitao.front.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 地区表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopArea implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 索引ID
     */
    private Integer areaId;
    /**
     * 地区名称
     */
    private String areaName;
    /**
     * 地区父ID
     */
    private Integer areaParentId;
    /**
     * 排序
     */
   @JsonIgnore
    private Integer areaSort;
    /**
     * 邮编
     */
    private Integer postCode;
    /**
     * 地区深度，从1开始
     */
    @JsonIgnore
    private Integer areaDeep;
    /**
     * 是否删除0:未删除;1:已删除
     */
    @JsonIgnore
    private Integer isDel;
    /**
     * 录入时间
     */
    @JsonIgnore
    private Date createdTime;
    /**
     * 更新时间(自更新)
     */
    @JsonIgnore
    private Date updatedTime;



    @Override
    public String toString() {
        return "ShopArea{" +
        "areaId=" + areaId +
        ", areaName=" + areaName +
        ", areaParentId=" + areaParentId +
        ", areaSort=" + areaSort +
        ", postCode=" + postCode +
        ", areaDeep=" + areaDeep +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}