package com.hzitxx.hitao.vo;


import java.util.Date;

public class ShopAdminVO {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员ID
     */
    private Integer adminId;
    /**
     * 管理员名称
     */
    private String adminName;
    /**
     * 管理员密码
     */
    private String adminPassword;
    /**
     * 登录次数
     */
    private Integer adminLoginNum;
    /**
     * 登陆的ip地址
     */
    private String loginIp;
    /**
     * 登陆状态 0:未登录 1:已登录,默认未登陆
     */
    private Integer loginStatus;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 删除状态
     */
    private Integer isDel;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 权限列表
     */
    private String actionList;
    /**
     * 导航栏配置
     */
    private String navList;
    /**
     * 录入人
     */
    private String createdBy;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 修改时间
     */
    private Date updatedTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Integer getAdminLoginNum() {
        return adminLoginNum;
    }

    public void setAdminLoginNum(Integer adminLoginNum) {
        this.adminLoginNum = adminLoginNum;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getActionList() {
        return actionList;
    }

    public void setActionList(String actionList) {
        this.actionList = actionList;
    }

    public String getNavList() {
        return navList;
    }

    public void setNavList(String navList) {
        this.navList = navList;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "ShopAdmin{" +
                "adminId=" + adminId +
                ", adminName=" + adminName +
                ", adminPassword=" + adminPassword +
                ", adminLoginNum=" + adminLoginNum +
                ", loginIp=" + loginIp +
                ", loginStatus=" + loginStatus +
                ", email=" + email +
                ", isDel=" + isDel +
                ", loginTime=" + loginTime +
                ", actionList=" + actionList +
                ", navList=" + navList +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
