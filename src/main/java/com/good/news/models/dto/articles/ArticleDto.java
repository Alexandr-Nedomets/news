package com.good.news.models.dto.articles;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ArticleDto {

    private Long id;
    private String name;
    private String description;
    private ZonedDateTime dataCreated;
    private ZonedDateTime dataUpdated;
    private String author;
}
