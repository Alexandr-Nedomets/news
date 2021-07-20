package com.good.news.managers.articles;

import com.good.news.models.dto.articles.ArticleDto;
import com.good.news.models.entity.articles.Article;
import com.good.news.services.articles.ArticleService;
import com.good.news.services.files.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

import static com.good.news.models.mappers.articles.ArticleMapper.ARTICLE_MAPPER;

@Service
@AllArgsConstructor
public class ArticleManager {

    private final ArticleService articleService;
    private final FileService fileService;

    public List<ArticleDto> findAll() {
        return ARTICLE_MAPPER.toListArticleDto(articleService.findAll());
    }

    public ArticleDto findById(Long id) {
        return ARTICLE_MAPPER.toArticleDto(articleService.findById(id));
    }

    public ArticleDto save(ArticleDto articleDto, MultipartFile file) {
        Article article = ARTICLE_MAPPER.toArticle(articleDto);
        String imageName = fileService.upload(file);
        article.getImage().setName(imageName);
        return ARTICLE_MAPPER.toArticleDto(articleService.save(article));
    }

    public void deleteById(Long id) {
        ArticleDto article = findById(id);
        fileService.delete(article.getImage().getName());
        articleService.deleteById(id);
    }

    public ArticleDto update(Long id, ArticleDto articleDto,  MultipartFile file) {
        Article article = ARTICLE_MAPPER.toArticle(articleDto);
        if (!Objects.equals(file.getOriginalFilename(), "")) {
            String imageToDelete = article.getImage().getName();
            fileService.delete(imageToDelete);
            String imagePath = fileService.upload(file);
            article.getImage().setName(imagePath);
        }
        return ARTICLE_MAPPER.toArticleDto(articleService.update(id, article));
    }

}
