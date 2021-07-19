package com.good.news.services.articles;

import com.good.news.repositories.articles.ArticleImagesRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleImagesService {

    private final ArticleImagesRepository articleImagesRepository;

    public ArticleImagesService(ArticleImagesRepository articleImagesRepository) {
        this.articleImagesRepository = articleImagesRepository;
    }
}
