package com.hzitxx.hitao.front.product;

import com.hzitxx.hitao.entity.ShopFrontCategory;
import lombok.Data;

import java.util.List;

/**
 * 类目封装类
 */
@Data
public class CategoryVo {
    /**
     * 类目名称
     */
    private String catName;

    private Integer catId;
    /**
     * 子级类目
     */
    private List<ShopFrontCategory> childrens;
}
