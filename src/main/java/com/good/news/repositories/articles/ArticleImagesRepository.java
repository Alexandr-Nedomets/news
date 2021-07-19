package com.good.news.repositories.articles;

import com.good.news.models.entity.articles.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleImagesRepository extends JpaRepository<ArticleImage, Long> {
}
