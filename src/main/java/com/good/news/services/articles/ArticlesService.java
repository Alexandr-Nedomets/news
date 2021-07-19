package com.good.news.services.articles;

import com.good.news.models.entity.articles.Article;
import com.good.news.models.entity.articles.ArticleImage;
import com.good.news.repositories.articles.ArticlesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ArticlesService {

    private final ArticlesRepository articlesRepository;
    private List<Article> articles;
    private List<ArticleImage> articleImages;

    {
        articleImages = Stream
                .of(
                        new ArticleImage(1L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 1"),
                        new ArticleImage(2L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 2"),
                        new ArticleImage(3L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 3"),
                        new ArticleImage(4L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 4"),
                        new ArticleImage(5L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 5"),
                        new ArticleImage(6L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 6"),
                        new ArticleImage(7L, "/uploads/images/97d4245b-f48e-47de-b085-66f8c425f770_123.jpg", "Черепаха 7")
                )
                .collect(Collectors.toList());
        articles = Stream
                .of(
                        new Article(1L, "Италия", "Италия выиграла Англию", LocalDateTime.now(), LocalDateTime.now(), "Сергей", articleImages.get(0)),
                        new Article(2L, "Англия", "Англия проиграла Италия", LocalDateTime.now(), LocalDateTime.now(), "Игнат", articleImages.get(1)),
                        new Article(3L, "Дания", "Дания проиграла Англии", LocalDateTime.now(), LocalDateTime.now(), "Иван", articleImages.get(2)),
                        new Article(4L, "Испания", "Испания проиграла Италии", LocalDateTime.now(), LocalDateTime.now(), "Николай", articleImages.get(3)),
                        new Article(5L, "Украина", "Украина победила Швецию", LocalDateTime.now(), LocalDateTime.now(), "Альберт", articleImages.get(4)),
                        new Article(6L, "Россия", "Россия победила Финляндию", LocalDateTime.now(), LocalDateTime.now(), "Зоя", articleImages.get(5)),
                        new Article(7L, "Бельгия", "Бельгия потерпела поражение", LocalDateTime.now(), LocalDateTime.now(), "Света", articleImages.get(6))
                )
                .collect(Collectors.toList());
    }

    @PostConstruct
    private void fillDB(){
        articlesRepository.saveAll(articles);
    }


    public ArticlesService(ArticlesRepository newsRepository) {
        this.articlesRepository = newsRepository;
    }

    public List<Article> findAll() {
        return articlesRepository.findAll();
    }

    public Article findById(Long id) {
        return articlesRepository.findById(id).orElse(new Article());
    }

    public Article save(Article news) {
        return articlesRepository.save(news);
    }

    public void deleteById(Long id) {
        articlesRepository.deleteById(id);
    }

    public Article update(Long id, Article article) {
        Article articleForUpdate = findById(id);
        articleForUpdate.setTitle(article.getTitle());
        articleForUpdate.setContent(article.getContent());
        articleForUpdate.setAuthor(article.getAuthor());
        return save(articleForUpdate);
    }
}
