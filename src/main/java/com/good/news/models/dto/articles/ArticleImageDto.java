package com.good.news.models.dto.articles;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ArticleImageDto {

    private Long id;
    private String name;
    @NotEmpty(message = "{article.description.is.not.empty}")
    @Size(min = 10, max = 50, message = "{article.description.size.min.max}")
    private String description;

}
