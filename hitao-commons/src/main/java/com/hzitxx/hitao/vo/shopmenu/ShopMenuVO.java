package com.hzitxx.hitao.vo.shopmenu;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-20
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopMenuVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * url路径
     */
//    private String url;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 是否删除  0:不进行 逻辑删除  1:进行逻辑删除
     */
    private Integer isDel;
    private List<ShopMenuVO> children = new ArrayList<>();

    @Override
    public String toString() {
        return "ShopMenu{" +
        "id=" + id +
        ", name=" + name +
        ", parentId=" + parentId +
        "}";
    }
}