package com.hzitxx.hitao.system.pojo.member;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * <p>
 * 会员表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
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
     * 会员性别 1.男 2.女
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
     * 预存款冻结金额
     */
    private BigDecimal freezePredeposit;
    /**
     * 是否允许举报(1可以/2不可以)
     */
    private Integer informAllow;
    /**
     * 会员是否有购买权限 1为开启 0为关闭
     */
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
 
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
 
    public String getMemberTruename() {
        return memberTruename;
    }

    public void setMemberTruename(String memberTruename) {
        this.memberTruename = memberTruename;
    }
 
    public String getMemberAvatar() {
        return memberAvatar;
    }

    public void setMemberAvatar(String memberAvatar) {
        this.memberAvatar = memberAvatar;
    }
 
    public Integer getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(Integer memberSex) {
        this.memberSex = memberSex;
    }
 
    public Date getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(Date memberBirthday) {
        this.memberBirthday = memberBirthday;
    }
 
    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
 
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
 
    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
 
    public Integer getMemberLoginNum() {
        return memberLoginNum;
    }

    public void setMemberLoginNum(Integer memberLoginNum) {
        this.memberLoginNum = memberLoginNum;
    }
 
    public Date getMemberTime() {
        return memberTime;
    }

    public void setMemberTime(Date memberTime) {
        this.memberTime = memberTime;
    }
 
    public Date getMemberLoginTime() {
        return memberLoginTime;
    }

    public void setMemberLoginTime(Date memberLoginTime) {
        this.memberLoginTime = memberLoginTime;
    }
 
    public Date getMemberOldLoginTime() {
        return memberOldLoginTime;
    }

    public void setMemberOldLoginTime(Date memberOldLoginTime) {
        this.memberOldLoginTime = memberOldLoginTime;
    }
 
    public String getMemberLoginIp() {
        return memberLoginIp;
    }

    public void setMemberLoginIp(String memberLoginIp) {
        this.memberLoginIp = memberLoginIp;
    }
 
    public String getMemberOldLoginIp() {
        return memberOldLoginIp;
    }

    public void setMemberOldLoginIp(String memberOldLoginIp) {
        this.memberOldLoginIp = memberOldLoginIp;
    }
 
    public Integer getMemberPoints() {
        return memberPoints;
    }

    public void setMemberPoints(Integer memberPoints) {
        this.memberPoints = memberPoints;
    }
 
    public Long getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(Long memberMobile) {
        this.memberMobile = memberMobile;
    }
 
    public BigDecimal getAvailablePredeposit() {
        return availablePredeposit;
    }

    public void setAvailablePredeposit(BigDecimal availablePredeposit) {
        this.availablePredeposit = availablePredeposit;
    }
 
    public BigDecimal getFreezePredeposit() {
        return freezePredeposit;
    }

    public void setFreezePredeposit(BigDecimal freezePredeposit) {
        this.freezePredeposit = freezePredeposit;
    }
 
    public Integer getInformAllow() {
        return informAllow;
    }

    public void setInformAllow(Integer informAllow) {
        this.informAllow = informAllow;
    }
 
    public Integer getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Integer isBuy) {
        this.isBuy = isBuy;
    }
 
    public Integer getIsAllowtalk() {
        return isAllowtalk;
    }

    public void setIsAllowtalk(Integer isAllowtalk) {
        this.isAllowtalk = isAllowtalk;
    }
 
    public Integer getMemberState() {
        return memberState;
    }

    public void setMemberState(Integer memberState) {
        this.memberState = memberState;
    }
 
    public Integer getMemberCredit() {
        return memberCredit;
    }

    public void setMemberCredit(Integer memberCredit) {
        this.memberCredit = memberCredit;
    }
 
    public Integer getMemberAreaid() {
        return memberAreaid;
    }

    public void setMemberAreaid(Integer memberAreaid) {
        this.memberAreaid = memberAreaid;
    }
 
    public Integer getMemberCityid() {
        return memberCityid;
    }

    public void setMemberCityid(Integer memberCityid) {
        this.memberCityid = memberCityid;
    }
 
    public Integer getMemberProvinceid() {
        return memberProvinceid;
    }

    public void setMemberProvinceid(Integer memberProvinceid) {
        this.memberProvinceid = memberProvinceid;
    }
 
    public String getMemberAreainfo() {
        return memberAreainfo;
    }

    public void setMemberAreainfo(String memberAreainfo) {
        this.memberAreainfo = memberAreainfo;
    }
 
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
 
    public Integer getIsSorf() {
        return isSorf;
    }

    public void setIsSorf(Integer isSorf) {
        this.isSorf = isSorf;
    }
 


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