package com.good.news.models.entity.articles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "article_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false, length = 5000)
    private String content;
    @Column(name = "date_created", nullable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Column(name = "date_updated", nullable = false)
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
    @Column(name = "author", nullable = false)
    private String author;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_image_id")
    private ArticleImage image;

}
