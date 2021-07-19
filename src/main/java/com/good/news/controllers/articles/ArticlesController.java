package com.good.news.controllers.articles;

import com.good.news.models.entity.articles.Article;
import com.good.news.services.articles.ArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/api/v001/articles")
public class ArticlesController {

    private final ArticlesService articlesService;

    public ArticlesController(ArticlesService postsService) {
        this.articlesService = postsService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("articles", articlesService.findAll());
        return "articles/articles";
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("article", articlesService.findById(id));
        return "articles/article";
    }

    @GetMapping(value = "/create")
    public String getFormForCreateArticle(@ModelAttribute(value = "article") Article article) {
        return "articles/create";
    }

    @GetMapping(value = "/{id}/update")
    public String getFormForUpdateArticle(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("article", articlesService.findById(id));
        return "articles/update";
    }

    @PutMapping(value = "/{id}")
    public String update(@ModelAttribute(value = "article") Article article,
                         @PathVariable(value = "id") Long id) {
        articlesService.update(id, article);
        return "redirect:/api/v001/articles/" + id;
    }

    @PostMapping
    public String save(@ModelAttribute(value = "article") Article article) {
        articlesService.save(article);
        return "redirect:/api/v001/articles";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        articlesService.deleteById(id);
        return "redirect:/api/v001/articles";
    }
}
