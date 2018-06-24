package com.hzitxx.hitao.front.product.vo;

import lombok.Data;

/**
 * {"regionType":1,selectRegionList:[
 *
 * ]}
 */
@Data
public class ShopAreaVo {
    /**
     * 地区编号
     */
    private int id;
    /**
     * 类型
     */
    private int type;
    /**
     * 父级编号
     */
    private int parentId;

    /**
     * 地区名称
     */
    private String name;
}
