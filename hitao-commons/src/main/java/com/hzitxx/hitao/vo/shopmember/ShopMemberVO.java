package com.hzitxx.hitao.vo.shopmember;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * ShopMemberVO
 * </p>
 *
 * @author xianyaoji
 * @since 2018-01-20
 */
@Data
public class ShopMemberVO implements Serializable {
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
    private String memberPassword;
    
    /**
     * 确认密码
     */
    private String confirmPassword;

    /**
     * 密码盐，用于提高会员的密码强度
     */
    private String passwordSalt;
    /**
     * 会员邮箱
     */
    private String memberEmail;
    /**
     * 登录次数
     */
    private Integer memberLoginNum;
    /**
     * 会员注册时间
     */
    private Date memberTime;
    /**
     * 当前登录时间
     */
    private Date memberLoginTime;
    /**
     * 上次登录时间
     */
    private Date memberOldLoginTime;
    /**
     * 当前登录ip
     */
    private String memberLoginIp;
    /**
     * 上次登录ip
     */
    private String memberOldLoginIp;
    /**
     * 会员积分
     */
    private Integer memberPoints;

    /**
     * 会员手机号码
     */
    private Long memberMobile;
    /**
     * 预存款可用金额
     */
    private BigDecimal availablePredeposit;

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
                ", memberAreaid=" + memberAreaid +
                ", memberCityid=" + memberCityid +
                ", memberProvinceid=" + memberProvinceid +
                ", memberAreainfo=" + memberAreainfo +
                "}";
    }
}