package com.threeFarmer.service.article.impl;

import com.threeFarmer.dao.article.IArticleFavorDao;
import com.threeFarmer.model.article.ArticleFavor;
import com.threeFarmer.service.article.IArticleFavorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("articleFavorService")
public class ArticleFavorServiceImpl implements IArticleFavorService {
    @Resource
    private IArticleFavorDao articleFavorDao;


    @Override
    public ArticleFavor find(Integer articleId, Integer memberId) {
        return articleFavorDao.find(articleId,memberId);
    }

    @Override
    public void save(Integer articleId, Integer memberId) {
        articleFavorDao.save(articleId,memberId);
    }

    @Override
    public void delete(Integer articleId, Integer memberId) {
        articleFavorDao.delete(articleId,memberId);
    }
}
