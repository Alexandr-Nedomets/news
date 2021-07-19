package com.good.news.managers.articles;

import com.good.news.models.entity.articles.Article;
import com.good.news.services.articles.ArticlesService;
import com.good.news.services.files.FilesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArticlesManager {

    private final ArticlesService articlesService;
    private final FilesService filesService;

    public ArticlesManager(ArticlesService articlesService, FilesService filesService) {
        this.articlesService = articlesService;
        this.filesService = filesService;
    }

    public List<Article> findAll() {
        return articlesService.findAll();
    }

    public Article findById(Long id) {
        return articlesService.findById(id);
    }

    public Article save(Article article, MultipartFile file) {
        String imagePath = filesService.upload(file);
        article.getImage().setPath(imagePath);
        return articlesService.save(article);
    }

    public void deleteById(Long id) {
        Article article = findById(id);
        filesService.delete(article.getImage().getPath());
        articlesService.deleteById(id);
    }

    public Article update(Long id, Article article,  MultipartFile file) {
        String imageToDelete = article.getImage().getPath();
        filesService.delete(imageToDelete);
        String imagePath = filesService.upload(file);
        article.getImage().setPath(imagePath);
        return articlesService.update(id, article);
    }
}
