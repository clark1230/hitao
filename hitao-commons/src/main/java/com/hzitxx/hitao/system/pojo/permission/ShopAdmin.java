package com.hzitxx.hitao.system.pojo.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import  java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员ID
     */
    private Integer adminId;
    /**
     * 管理员名称
     */
    @NotBlank(message = "用户名不能为空!")
    private String adminName;
    /**
     * 管理员密码
     */
    @NotBlank(message = "密码不能为空!")
    @Length(max=20,min=6,message = "密码长度在[6,20]之间!")
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
    @Email(message = "邮箱格式不正确!")
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
    private Integer createdBy;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private Integer updatedBy;
    /**
     * 修改时间
     */
    private Date updatedTime;

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