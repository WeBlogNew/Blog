package com.threeFarmer.service.article.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.threeFarmer.common.Const;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.StringUtils;
import com.threeFarmer.dao.article.IArticleDao;
import com.threeFarmer.model.article.Article;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.article.IArticleCommentService;
import com.threeFarmer.service.article.IArticleFavorService;
import com.threeFarmer.service.article.IArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private IArticleDao articleDao;
    @Resource
    private IArticleFavorService articleFavorService;

    @Resource
    private IArticleCommentService articleCommentService;


    @Override
    public Article findById(int id) {
        Article article = articleDao.findById(id);
        //this.atFormat(article);
        return article;
    }

    @Override
    @Transactional
    public ResponseModel save(Member member, Article article) {
        article.setMemberId(member.getId());
        if(member.getIsAdmin() == 0){
            article.setStatus(0);
        }else {
            article.setStatus(1);
        }
        if(article.getViewRank() == null){
            article.setViewCount(0);
        }
        article.setThumbnail(Const.DEFAULT_IMG_URL);
        if (articleDao.save(article) == 1) {
            if (article.getStatus() == 0) {
                return new ResponseModel(0, "文章发布成功，请等待审核");
            }
            return new ResponseModel(0, "文章发布成功");
        }
        return new ResponseModel(-1,"文章发布失败");
    }

    @Override
    public ResponseModel listByPage(Page page, String key, int status, Integer memberId) {
        if (StringUtils.isNotBlank(key)){
            key = "%"+key.trim()+"%";
        }

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<Article> list = articleDao.listByPage(key,status,memberId);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        ResponseModel model = new ResponseModel(0);
        model.setData(pageInfo);
        return model;
    }

    @Override
    public void updateViewCount(int id) {
        articleDao.updateViewCount(id);
    }

    @Override
    public ResponseModel audit(int id) {
        if(articleDao.audit(id) == 1){
            return new ResponseModel(1,"操作成功");
        }else {
            return new ResponseModel(-1,"操作时候");
        }
    }

    @Override
    public ResponseModel favor(Member loginMember, int articleId) {
        Article article = this.findById(articleId);
        if(article != null){
            String message;
            ResponseModel<Integer> responseModel;
            if(articleFavorService.find(articleId,loginMember.getId()) == null){
                //增加
                articleDao.favor(articleId,1);
                articleFavorService.save(articleId,loginMember.getId());
                message = "喜欢成功";
                responseModel = new ResponseModel<>(0,message);
            }else {
                //减少
                articleDao.favor(articleId,-1);
                articleFavorService.delete(articleId,loginMember.getId());
                message = "取消喜欢成功";
                responseModel = new ResponseModel<>(1,message);
            }
            return responseModel;
        }
        return new ResponseModel(-1,"文章不存在");
    }

    @Override
    @Transactional
    public ResponseModel update(Member member,Article article) {
        Article findArticle = this.findById(article.getId());
        if(findArticle == null){
            return new ResponseModel(-2);
        }
        article.setId(findArticle.getId());
        findArticle.setTitle(article.getTitle());
        findArticle.setThumbnail(article.getThumbnail());
        findArticle.setContent(article.getContent());
        findArticle.setDescription(article.getDescription());
        findArticle.setKeywords(article.getKeywords());
        if(articleDao.update(findArticle) == 1){
            return new ResponseModel(0,"更新成功");
        }
        return new ResponseModel(-1,"更新失败");
    }

    @Override
    @Transactional
    public ResponseModel delete(Member member,int id) {
        Article article = this.findById(id);
        if (article == null){
            return new ResponseModel(-1,"文章不存在");
        }
        int result = articleDao.delete(id);
        if(result == 1){
            articleCommentService.deleteByArticle(id);
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

}
