package com.hzitxx.hitao.system.pojo;

import  java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-01-20
 */
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 会员编号
     */
    private Long aoocuntId;
    /**
     * 会员名称
     */
    private String name;
    /**
     * 会员手机号码
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;

    private String password2;
    /**
     * 密码盐,提高密码强度
     */
    private String salt;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 身份证号码
     */
    private String idcard;
    /**
     * 性别 , 1:男 2:女 3:保密
     */
    private Integer gender;
    /**
     * 会员生日
     */
    private Long birthday;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 注册时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long updateTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 余额
     */
    private BigDecimal money;

    public Long getAoocuntId() {
        return aoocuntId;
    }

    public void setAoocuntId(Long aoocuntId) {
        this.aoocuntId = aoocuntId;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
 
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
 
    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
 
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
 
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
 
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
 
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
 
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "Member{" +
        "aoocuntId=" + aoocuntId +
        ", name=" + name +
        ", mobile=" + mobile +
        ", password=" + password +
        ", salt=" + salt +
        ", email=" + email +
        ", idcard=" + idcard +
        ", gender=" + gender +
        ", birthday=" + birthday +
        ", hobby=" + hobby +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", remark=" + remark +
        ", money=" + money +
        "}";
    }
}