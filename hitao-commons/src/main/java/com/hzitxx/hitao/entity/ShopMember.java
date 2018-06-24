package com.hzitxx.hitao.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import  java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-03-18
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 会员名称
     */
    private String memberName;
    /**
     * 真实姓名
     */
    private String memberTruename;
    /**
     * 会员头像
     */
    private String memberAvatar;
    /**
     * 会员性别
     */
    private Integer memberSex;
    /**
     * 生日
     */
    private Date memberBirthday;
    /**
     * 会员密码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memberPassword;
    /**
     * 密码盐，用于提高会员的密码强度
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String passwordSalt;
    /**
     * 会员邮箱
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memberEmail;
    /**
     * 登录次数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer memberLoginNum;
    /**
     * 会员注册时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date memberTime;
    /**
     * 当前登录时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date memberLoginTime;
    /**
     * 上次登录时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date memberOldLoginTime;
    /**
     * 当前登录ip
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memberLoginIp;
    /**
     * 上次登录ip
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memberOldLoginIp;
    /**
     * 会员积分
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer memberPoints;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long memberMobile;
    /**
     * 预存款可用金额
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal availablePredeposit;
    /**
     * 预存款冻结金额
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal freezePredeposit;
    /**
     * 是否允许举报(1可以/2不可以)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer informAllow;
    /**
     * 会员是否有购买权限 1为开启 0为关闭
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer isBuy;
    /**
     * 会员是否有咨询和发送站内信的权限 1为开启 0为关闭
     */
    private Integer isAllowtalk;
    /**
     * 会员的开启状态 1为开启 0为关闭
     */
    private Integer memberState;
    /**
     * 会员信用
     */
    private Integer memberCredit;
    /**
     * 地区ID
     */
    private Integer memberAreaid;
    /**
     * 城市ID
     */
    private Integer memberCityid;
    /**
     * 省份ID
     */
    private Integer memberProvinceid;
    /**
     * 地区内容
     */
    private String memberAreainfo;
    /**
     * 删除标志
     */
    private Integer isDel;
    /**
     * 能够在卖家中展示
     */
    private Integer isSorf;


    @Override
    public String toString() {
        return "ShopMember{" +
        "memberId=" + memberId +
        ", memberName=" + memberName +
        ", memberTruename=" + memberTruename +
        ", memberAvatar=" + memberAvatar +
        ", memberSex=" + memberSex +
        ", memberBirthday=" + memberBirthday +
        ", memberPassword=" + memberPassword +
        ", passwordSalt=" + passwordSalt +
        ", memberEmail=" + memberEmail +
        ", memberLoginNum=" + memberLoginNum +
        ", memberTime=" + memberTime +
        ", memberLoginTime=" + memberLoginTime +
        ", memberOldLoginTime=" + memberOldLoginTime +
        ", memberLoginIp=" + memberLoginIp +
        ", memberOldLoginIp=" + memberOldLoginIp +
        ", memberPoints=" + memberPoints +
        ", memberMobile=" + memberMobile +
        ", availablePredeposit=" + availablePredeposit +
        ", freezePredeposit=" + freezePredeposit +
        ", informAllow=" + informAllow +
        ", isBuy=" + isBuy +
        ", isAllowtalk=" + isAllowtalk +
        ", memberState=" + memberState +
        ", memberCredit=" + memberCredit +
        ", memberAreaid=" + memberAreaid +
        ", memberCityid=" + memberCityid +
        ", memberProvinceid=" + memberProvinceid +
        ", memberAreainfo=" + memberAreainfo +
        ", isDel=" + isDel +
        ", isSorf=" + isSorf +
        "}";
    }
}