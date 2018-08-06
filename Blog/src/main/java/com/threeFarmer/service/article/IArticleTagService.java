package com.threeFarmer.service.article;

import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.article.ArticleTag;

import java.util.List;

public interface IArticleTagService {

    ArticleTag findById(int id);

    int save(ArticleTag articleTag);

    int update(ArticleTag articleTag);

    ResponseModel delete(int id);

    /**
     * 获取栏目
     * @return
     */
    List<ArticleTag> list();

}
