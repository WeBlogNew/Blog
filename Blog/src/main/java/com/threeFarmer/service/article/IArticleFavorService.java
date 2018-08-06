package com.threeFarmer.service.article;

import com.threeFarmer.model.article.ArticleFavor;

public interface IArticleFavorService {

    ArticleFavor find(Integer archiveId, Integer memberId);

    void save(Integer archiveId, Integer memberId);

    void delete(Integer archiveId, Integer memberId);
}