package com.threeFarmer.dao.article;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.article.ArticleFavor;
import org.apache.ibatis.annotations.Param;

/**
 * 文章点赞DAO接口
 */
public interface IArticleFavorDao extends IBaseDao<ArticleFavor> {

    ArticleFavor find(@Param("articleId") Integer articleId, @Param("memberId") Integer memberId);

    Integer save(@Param("articleId") Integer articleId, @Param("memberId") Integer memberId);

    Integer delete(@Param("articleId") Integer articleId, @Param("memberId") Integer memberId);
}