package com.threeFarmer.service.article;

import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.article.ArticleComment;
import com.threeFarmer.model.member.Member;

public interface IArticleCommentService {

    ArticleComment findById(int id);

    ResponseModel save(Member loginMember, String content, Integer articleId);

    ResponseModel delete(Member loginMember, int id);

    ResponseModel listByArticle(Page page, int articleId);

    void deleteByArticle(Integer articleId);
}
