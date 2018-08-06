package com.threeFarmer.dao.article;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.article.ArticleTag;

import java.util.List;

/**
 * 文章栏目DAO接口
 */
public interface IArticleTagDao extends IBaseDao<ArticleTag> {

    /**
     * 获取栏目
     * @return
     */
    List<ArticleTag> list();

}