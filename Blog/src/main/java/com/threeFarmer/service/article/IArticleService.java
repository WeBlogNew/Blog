package com.threeFarmer.service.article;

import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.article.Article;
import com.threeFarmer.model.member.Member;

public interface IArticleService {

    Article findById(int id);

    ResponseModel save(Member member, Article article);

    ResponseModel update(Member member, Article article);

    ResponseModel delete(Member member, int id);

    ResponseModel listByPage(Page page, String key, int status, Integer memberId);

    void updateViewCount(int id);

    ResponseModel audit(int id);

    ResponseModel favor(Member loginMember, int articleId);

}
