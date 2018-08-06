package com.threeFarmer.service.article.impl;

import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.dao.article.IArticleDao;
import com.threeFarmer.dao.article.IArticleTagDao;
import com.threeFarmer.model.article.ArticleTag;
import com.threeFarmer.service.article.IArticleTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("articleTagService")
public class ArticleTagServiceImpl implements IArticleTagService {

    @Resource
    private IArticleTagDao articleTagDao;

    @Override
    public ArticleTag findById(int id) {
        ArticleTag articleTag = articleTagDao.findById(id);
        return articleTag;
    }

    @Override
    public int save(ArticleTag articleTag) {
        return articleTagDao.save(articleTag);
    }

    @Override
    public int update(ArticleTag articleTag) {
        return articleTagDao.update(articleTag);
    }

    @Override
    @Transactional
    public ResponseModel delete(int id) {
        int result = articleTagDao.delete(id);

        if(result == 1){
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    @Override
    public List<ArticleTag> list() {
        return articleTagDao.list();
    }


}
