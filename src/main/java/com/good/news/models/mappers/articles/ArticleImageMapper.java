package com.good.news.models.mappers.articles;

import com.good.news.models.dto.articles.ArticleImageDto;
import com.good.news.models.entity.articles.ArticleImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleImageMapper {

    ArticleImageMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleImageMapper.class);

    ArticleImage toArticleImage(ArticleImageDto articleImageDto);

    ArticleImageDto toArticleImageDto(ArticleImage articleImage);

}
