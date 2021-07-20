package com.good.news.models.dto.articles;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class ArticleDto {

    private Long id;
    @NotEmpty(message = "{article.title.is.not.empty}")
    @Size(min = 10, max = 50, message = "{article.title.size.min.max}")
    private String title;
    @NotEmpty(message = "{article.content.is.not.empty}")
    @Size(min = 300, max = 5000, message = "{article.content.size.min.max}")
    private String content;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    @NotEmpty(message = "{article.author.is.not.empty}")
    @Size(min = 2, max = 50, message = "{article.author.size.min.max}")
    private String author;
    @Valid
    private ArticleImageDto image;

}
