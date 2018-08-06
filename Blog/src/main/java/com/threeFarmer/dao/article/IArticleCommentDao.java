package com.threeFarmer.dao.article;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.article.ArticleComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章评论DAO接口
 */
public interface IArticleCommentDao extends IBaseDao<ArticleComment> {

    List<ArticleComment> listByArticle(@Param("articleId") Integer articleId);

    int deleteByArticle(@Param("articleId") Integer articleId);
}