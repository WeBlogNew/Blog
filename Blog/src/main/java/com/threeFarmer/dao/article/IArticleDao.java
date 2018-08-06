package com.threeFarmer.dao.article;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.article.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章DAO接口
 */
public interface IArticleDao extends IBaseDao<Article>{

    /**
     * 更新阅读数
     * @param articleId
     * @return
     */
    int updateViewCount(@Param("articleId") int articleId);

    /**
     * 审核文章
     * @param id
     * @return
     */
    int audit(@Param("id") int id);

    int favor(@Param("articleId") int articleId, @Param("num") int num);

    List<Article> listByPage(@Param("key") String key, @Param("status") Integer status, @Param("memberId") Integer memberId);

}
