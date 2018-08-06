package com.threeFarmer.model.article;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章点赞记录实体类
 */
public class ArticleFavor implements Serializable {
    private Integer id;
    private Date createTime;
    private Integer memberId;
    private Integer articleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
