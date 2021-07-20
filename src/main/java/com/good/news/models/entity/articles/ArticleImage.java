package com.good.news.models.entity.articles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article_images")
public class ArticleImage {

    @Id
    @Column(name = "article_image_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_name", unique = true, nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

}
