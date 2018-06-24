package com.hzitxx.hitao.entity;

import lombok.Data;

import  java.io.Serializable;
/**
 * <p>
 * CMS文章表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-11
 */
@Data
public class ShopArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 文章编号
     */
    private Integer articleId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章分类编号
     */
    private Integer articleClassId;
    /**
     * 文章来源
     */
    private String articleOrigin;
    /**
     * 文章来源链接
     */
    private String articleOriginAddress;
    /**
     * 文章作者
     */
    private String articleAuthor;
    /**
     * 文章摘要
     */
    private String articleAbstract;
    /**
     * 文章正文
     */
    private String articleContent;
    /**
     * 文章图片
     */
    private String articleImage;
    /**
     * 文章关键字
     */
    private String articleKeyword;
    /**
     * 相关文章
     */
    private String articleLink;
    /**
     * 相关商品
     */
    private String articleGoods;
    /**
     * 文章有效期开始时间
     */
    private Integer articleStartTime;
    /**
     * 文章有效期结束时间
     */
    private Integer articleEndTime;
    /**
     * 文章发布时间
     */
    private Integer articlePublishTime;
    /**
     * 文章点击量
     */
    private Integer articleClick;
    /**
     * 文章排序0-255
     */
    private Integer articleSort;
    /**
     * 文章推荐标志0-未推荐，1-已推荐
     */
    private Integer articleCommendFlag;
    /**
     * 文章是否允许评论1-允许，0-不允许
     */
    private Integer articleCommentFlag;
    /**
     * 文章审核管理员
     */
    private String articleVerifyAdmin;
    /**
     * 文章审核时间
     */
    private Integer articleVerifyTime;
    /**
     * 1-草稿、2-待审核、3-已发布、4-回收站
     */
    private Integer articleState;
    /**
     * 发布者用户名
     */
    private String articlePublisherName;
    /**
     * 发布者编号
     */
    private Integer articlePublisherId;
    /**
     * 文章附件路径
     */
    private String articleAttachmentPath;
    /**
     * 文章全部图片
     */
    private String articleImageAll;
    /**
     * 文章修改时间
     */
    private Integer articleModifyTime;
    /**
     * 文章标签
     */
    private String articleTag;
    /**
     * 文章评论数
     */
    private Integer articleCommentCount;
    /**
     * 文章推荐标志(图文)
     */
    private Integer articleCommendImageFlag;
    /**
     * 文章分享数
     */
    private Integer articleShareCount;
    /**
     * 审核失败原因
     */
    private String articleVerifyReason;


    @Override
    public String toString() {
        return "ShopArticle{" +
        "articleId=" + articleId +
        ", articleTitle=" + articleTitle +
        ", articleClassId=" + articleClassId +
        ", articleOrigin=" + articleOrigin +
        ", articleOriginAddress=" + articleOriginAddress +
        ", articleAuthor=" + articleAuthor +
        ", articleAbstract=" + articleAbstract +
        ", articleContent=" + articleContent +
        ", articleImage=" + articleImage +
        ", articleKeyword=" + articleKeyword +
        ", articleLink=" + articleLink +
        ", articleGoods=" + articleGoods +
        ", articleStartTime=" + articleStartTime +
        ", articleEndTime=" + articleEndTime +
        ", articlePublishTime=" + articlePublishTime +
        ", articleClick=" + articleClick +
        ", articleSort=" + articleSort +
        ", articleCommendFlag=" + articleCommendFlag +
        ", articleCommentFlag=" + articleCommentFlag +
        ", articleVerifyAdmin=" + articleVerifyAdmin +
        ", articleVerifyTime=" + articleVerifyTime +
        ", articleState=" + articleState +
        ", articlePublisherName=" + articlePublisherName +
        ", articlePublisherId=" + articlePublisherId +
        ", articleAttachmentPath=" + articleAttachmentPath +
        ", articleImageAll=" + articleImageAll +
        ", articleModifyTime=" + articleModifyTime +
        ", articleTag=" + articleTag +
        ", articleCommentCount=" + articleCommentCount +
        ", articleCommendImageFlag=" + articleCommendImageFlag +
        ", articleShareCount=" + articleShareCount +
        ", articleVerifyReason=" + articleVerifyReason +
        "}";
    }
}