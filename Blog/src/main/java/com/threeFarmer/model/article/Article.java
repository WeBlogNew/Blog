package com.threeFarmer.model.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.threeFarmer.model.member.Member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章实体类
 */
public class Article implements Serializable {
    private Integer id;

    @NotBlank(message = "文章标题不能为空")
    private String title;

    private Integer memberId;

    private Member member;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String description;

    private String keywords;

    @Digits(integer = 1,fraction = 0,message = "浏览权限只能是数字")
    private Integer viewRank;

    @Digits(integer = 11,fraction = 0,message = "浏览数只能是数字")
    private Integer viewCount;

    private String writer;

    private String source;

    private Date pubTime;

    private Date updateTime;

    private String thumbnail;

    private Date lastReply;

    private Integer canReply;

    private Integer goodNum;

    private Integer badNum;

    private Integer checkAdmin;

    private Integer status;

    @NotBlank(message = "文章内容不能为空")
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getViewRank() {
        return viewRank;
    }

    public void setViewRank(Integer viewRank) {
        this.viewRank = viewRank;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getThumbnail() {
        return "".equals(thumbnail) ? null:thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getLastReply() {
        return lastReply;
    }

    public void setLastReply(Date lastReply) {
        this.lastReply = lastReply;
    }

    public Integer getCanReply() {
        return canReply;
    }

    public void setCanReply(Integer canReply) {
        this.canReply = canReply;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getBadNum() {
        return badNum;
    }

    public void setBadNum(Integer badNum) {
        this.badNum = badNum;
    }

    public Integer getCheckAdmin() {
        return checkAdmin;
    }

    public void setCheckAdmin(Integer checkAdmin) {
        this.checkAdmin = checkAdmin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}