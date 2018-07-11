package com.hzitxx.hitao.system.pojo.product;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 属性和属性组中间表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-07-07
 */
public class ShopGoodsAttrGroupTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private Integer id;
    /**
     * 属性编号
     */
    private Integer attrId;
    /**
     * 属性组编号
     */
    private Integer attrGroupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }
 
    public Integer getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Integer attrGroupId) {
        this.attrGroupId = attrGroupId;
    }
 


    @Override
    public String toString() {
        return "ShopGoodsAttrGroupTemp{" +
        "id=" + id +
        ", attrId=" + attrId +
        ", attrGroupId=" + attrGroupId +
        "}";
    }
}