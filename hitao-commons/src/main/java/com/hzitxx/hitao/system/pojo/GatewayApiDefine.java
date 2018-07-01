package com.hzitxx.hitao.system.pojo;

import  java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-07
 */
public class GatewayApiDefine implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private String id;
    /**
     * 请求匹配路径
     */
    private String path;
    /**
     * 注册服务的名称
     */
    private String serviceId;
    /**
     * 代理服务地址
     */
    private String url;
    /**
     * 是否可以重试
     */
    private Boolean retryable=false;
    /**
     * 是否启用
     */
    private Boolean enabled=false;
    /**
     * 是否忽略访问前缀
     */
    private Boolean stripPrefix=true;
    /**
     * api名称
     */
    private String apiName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
 
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
 
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
 
    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }
 
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
 
    public Boolean getStripPrefix() {
        return stripPrefix;
    }

    public void setStripPrefix(Boolean stripPrefix) {
        this.stripPrefix = stripPrefix;
    }
 
    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
 


    @Override
    public String toString() {
        return "GatewayApiDefine{" +
        "id=" + id +
        ", path=" + path +
        ", serviceId=" + serviceId +
        ", url=" + url +
        ", retryable=" + retryable +
        ", enabled=" + enabled +
        ", stripPrefix=" + stripPrefix +
        ", apiName=" + apiName +
        "}";
    }
}