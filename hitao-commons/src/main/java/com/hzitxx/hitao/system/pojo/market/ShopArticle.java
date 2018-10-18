package com.hzitxx.hitao.system.pojo.market;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * CMS文章表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-08
 */
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
    private Long articleStartTime;
    /**
     * 文章有效期结束时间
     */
    private Long articleEndTime;
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
     * 文章推荐标志(图文) 0:不是图片 1:图文
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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
 
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
 
    public Integer getArticleClassId() {
        return articleClassId;
    }

    public void setArticleClassId(Integer articleClassId) {
        this.articleClassId = articleClassId;
    }
 
    public String getArticleOrigin() {
        return articleOrigin;
    }

    public void setArticleOrigin(String articleOrigin) {
        this.articleOrigin = articleOrigin;
    }
 
    public String getArticleOriginAddress() {
        return articleOriginAddress;
    }

    public void setArticleOriginAddress(String articleOriginAddress) {
        this.articleOriginAddress = articleOriginAddress;
    }
 
    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }
 
    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }
 
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
 
    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }
 
    public String getArticleKeyword() {
        return articleKeyword;
    }

    public void setArticleKeyword(String articleKeyword) {
        this.articleKeyword = articleKeyword;
    }
 
    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }
 
    public String getArticleGoods() {
        return articleGoods;
    }

    public void setArticleGoods(String articleGoods) {
        this.articleGoods = articleGoods;
    }
 
    public Long getArticleStartTime() {
        return articleStartTime;
    }

    public void setArticleStartTime(Long articleStartTime) {
        this.articleStartTime = articleStartTime;
    }
 
    public Long getArticleEndTime() {
        return articleEndTime;
    }

    public void setArticleEndTime(Long articleEndTime) {
        this.articleEndTime = articleEndTime;
    }
 
    public Integer getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(Integer articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }
 
    public Integer getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
    }
 
    public Integer getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(Integer articleSort) {
        this.articleSort = articleSort;
    }
 
    public Integer getArticleCommendFlag() {
        return articleCommendFlag;
    }

    public void setArticleCommendFlag(Integer articleCommendFlag) {
        this.articleCommendFlag = articleCommendFlag;
    }
 
    public Integer getArticleCommentFlag() {
        return articleCommentFlag;
    }

    public void setArticleCommentFlag(Integer articleCommentFlag) {
        this.articleCommentFlag = articleCommentFlag;
    }
 
    public String getArticleVerifyAdmin() {
        return articleVerifyAdmin;
    }

    public void setArticleVerifyAdmin(String articleVerifyAdmin) {
        this.articleVerifyAdmin = articleVerifyAdmin;
    }
 
    public Integer getArticleVerifyTime() {
        return articleVerifyTime;
    }

    public void setArticleVerifyTime(Integer articleVerifyTime) {
        this.articleVerifyTime = articleVerifyTime;
    }
 
    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }
 
    public String getArticlePublisherName() {
        return articlePublisherName;
    }

    public void setArticlePublisherName(String articlePublisherName) {
        this.articlePublisherName = articlePublisherName;
    }
 
    public Integer getArticlePublisherId() {
        return articlePublisherId;
    }

    public void setArticlePublisherId(Integer articlePublisherId) {
        this.articlePublisherId = articlePublisherId;
    }
 
    public String getArticleAttachmentPath() {
        return articleAttachmentPath;
    }

    public void setArticleAttachmentPath(String articleAttachmentPath) {
        this.articleAttachmentPath = articleAttachmentPath;
    }
 
    public String getArticleImageAll() {
        return articleImageAll;
    }

    public void setArticleImageAll(String articleImageAll) {
        this.articleImageAll = articleImageAll;
    }
 
    public Integer getArticleModifyTime() {
        return articleModifyTime;
    }

    public void setArticleModifyTime(Integer articleModifyTime) {
        this.articleModifyTime = articleModifyTime;
    }
 
    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }
 
    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }
 
    public Integer getArticleCommendImageFlag() {
        return articleCommendImageFlag;
    }

    public void setArticleCommendImageFlag(Integer articleCommendImageFlag) {
        this.articleCommendImageFlag = articleCommendImageFlag;
    }
 
    public Integer getArticleShareCount() {
        return articleShareCount;
    }

    public void setArticleShareCount(Integer articleShareCount) {
        this.articleShareCount = articleShareCount;
    }
 
    public String getArticleVerifyReason() {
        return articleVerifyReason;
    }

    public void setArticleVerifyReason(String articleVerifyReason) {
        this.articleVerifyReason = articleVerifyReason;
    }
 


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