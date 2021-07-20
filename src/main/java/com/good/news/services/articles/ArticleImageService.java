package com.good.news.services.articles;

import com.good.news.repositories.articles.ArticleImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticleImageService {

    private final ArticleImageRepository articleImageRepository;

}
