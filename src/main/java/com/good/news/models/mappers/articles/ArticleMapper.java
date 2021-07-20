package com.good.news.models.mappers.articles;

import com.good.news.models.dto.articles.ArticleDto;
import com.good.news.models.entity.articles.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ArticleMapper {

    ArticleMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleMapper.class);

    Article toArticle(ArticleDto articleDto);

    ArticleDto toArticleDto(Article article);

    List<ArticleDto> toListArticleDto(Collection<Article> articles);

}
