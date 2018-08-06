package com.threeFarmer.service.article.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.StringUtils;
import com.threeFarmer.dao.article.IArticleCommentDao;
import com.threeFarmer.model.article.Article;
import com.threeFarmer.model.article.ArticleComment;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.article.IArticleCommentService;
import com.threeFarmer.service.article.IArticleService;
import com.threeFarmer.service.member.IMemberService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("articleCommentService")
public class ArticleCommentServiceImpl implements IArticleCommentService {
    @Resource
    private IArticleCommentDao articleCommentDao;
    @Resource
    private IArticleService articleService;
    @Resource
    private IMemberService memberService;

    @Override
    public ArticleComment findById(int id) {
        return articleCommentDao.findById(id);
    }

    @Override
    public ResponseModel save(Member loginMember, String content, Integer articleId) {
        Article article = articleService.findById(articleId);
        if(article == null){
            return new ResponseModel(-1,"文章不存在");
        }
        if(StringUtils.isEmpty(content)){
            return new ResponseModel(-1,"内容不能为空");
        }
        ArticleComment articleComment = new ArticleComment();
        articleComment.setMemberId(loginMember.getId());
        articleComment.setArticleId(articleId);
        articleComment.setContent(content);
        int result = articleCommentDao.save(articleComment);
        if(result == 1){
            return new ResponseModel(1,"评论成功");
        }else {
            return new ResponseModel(-1,"评论失败");
        }
    }

    @Override
    public ResponseModel listByArticle(Page page, int articleId) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<ArticleComment> list = articleCommentDao.listByArticle(articleId);
        PageInfo<ArticleComment> pageInfo = new PageInfo<>(list);
        ResponseModel model = new ResponseModel(0);
        model.setData(pageInfo);
        return model;
    }

    @Override
    public void deleteByArticle(Integer articleId) {
        articleCommentDao.deleteByArticle(articleId);
    }

    @Override
    @Transactional
    public ResponseModel delete(Member loginMember, int id) {
        ArticleComment articleComment = this.findById(id);
        if(articleComment == null){
            return new ResponseModel(-1,"评论不存在");
        }
        int result = articleCommentDao.delete(id);
        if(result == 1){
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }
}
