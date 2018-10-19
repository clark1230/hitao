package com.hzitxx.hitao.system.pojo.order;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 订单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-10-19
 */
@Data
public class ShopOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单索引id
     */
    private Integer orderId;
    /**
     * 订单编号
     */
    private Long orderSn;
    /**
     * 支付单号
     */
    private Long paySn;
    /**
     * 买家id
     */
    private Integer buyerId;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家电子邮箱
     */
    private String buyerEmail;
    /**
     * 订单生成时间
     */
    private Date addTime;
    /**
     * 支付方式名称代码
     */
    private String paymentCode;
    /**
     * 支付(付款)时间
     */
    private Date paymentTime;
    /**
     * 订单完成时间
     */
    private Date finnshedTime;
    /**
     * 商品总价格
     */
    private Long goodsAmount;
    /**
     * 订单总价格
     */
    private Long orderAmount;
    /**
     * 预存款支付金额
     */
    private Long pdAmount;
    /**
     * 运费
     */
    private Long shippingFee;
    /**
     * 评价状态 0未评价，1已评价
     */
    private Integer evaluationState;
    /**
     * 订单状态：0(已取消)10(默认):未付款;20:已付款;30:已发货;40:已收货;
     */
    private Integer orderState;
    /**
     * 退款状态:0是无退款,1是部分退款,2是全部退款
     */
    private Integer refundState;
    /**
     * 锁定状态:0是正常,大于0是锁定,默认是0
     */
    private Integer lockState;
    /**
     * 退款金额
     */
    private Long refundAmount;
    /**
     * 延迟时间,默认为0
     */
    private Date delayTime;
    /**
     * 物流单号
     */
    private String shippingCode;
    /**
     * 是否删除
     */
    private Integer isDel;
    /**
     * 下单时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;


    @Override
    public String toString() {
        return "ShopOrder{" +
        "orderId=" + orderId +
        ", orderSn=" + orderSn +
        ", paySn=" + paySn +
        ", buyerId=" + buyerId +
        ", buyerName=" + buyerName +
        ", buyerEmail=" + buyerEmail +
        ", addTime=" + addTime +
        ", paymentCode=" + paymentCode +
        ", paymentTime=" + paymentTime +
        ", finnshedTime=" + finnshedTime +
        ", goodsAmount=" + goodsAmount +
        ", orderAmount=" + orderAmount +
        ", pdAmount=" + pdAmount +
        ", shippingFee=" + shippingFee +
        ", evaluationState=" + evaluationState +
        ", orderState=" + orderState +
        ", refundState=" + refundState +
        ", lockState=" + lockState +
        ", refundAmount=" + refundAmount +
        ", delayTime=" + delayTime +
        ", shippingCode=" + shippingCode +
        ", isDel=" + isDel +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}