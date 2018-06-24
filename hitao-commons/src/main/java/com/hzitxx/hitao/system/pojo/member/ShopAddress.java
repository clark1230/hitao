package com.hzitxx.hitao.system.pojo.member;

import lombok.Data;

import  java.io.Serializable;
/**
 * <p>
 * 买家地址信息表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
@Data
public class ShopAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 地址ID
     */
    private Integer id;
    /**
     * 会员ID
     */
    private Integer memberId;
    /**
     * 会员姓名
     */
    private String memberName;
    /**
     * 省份id
     */
    private Integer provinceId;
    /**
     * 市级ID
     */
    private Integer cityId;
    /**
     * 地区ID
     */
    private Integer districtId;
    /**
     * 地区内容
     */
    private String fullRegion;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机电话
     */
    private String telNumber;
    /**
     * 邮编
     */
    private Integer postCode;
    /**
     * 1默认收货地址
     */
    private Integer isDefault;


    @Override
    public String toString() {
        return "ShopAddress{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", memberName=" + memberName +
        ", provinceId=" + provinceId +
        ", cityId=" + cityId +
        ", districtId=" + districtId +
        ", fullRegion=" + fullRegion +
        ", address=" + address +
        ", telNumber=" + telNumber +
        ", postCode=" + postCode +
        ", isDefault=" + isDefault +
        "}";
    }
}