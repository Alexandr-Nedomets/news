package com.good.news.services.articles;

import com.good.news.models.entity.articles.Article;
import com.good.news.repositories.articles.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(new Article());
    }

    public Article save(Article news) {
        return articleRepository.save(news);
    }

    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    public Article update(Long id, Article article) {
        Article articleForUpdate = findById(id);
        articleForUpdate.setTitle(article.getTitle());
        articleForUpdate.setContent(article.getContent());
        articleForUpdate.setAuthor(article.getAuthor());
        articleForUpdate.setImage(article.getImage());
        return save(articleForUpdate);
    }

}
