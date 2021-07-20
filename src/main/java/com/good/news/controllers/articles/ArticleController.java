package com.good.news.controllers.articles;

import com.good.news.managers.articles.ArticleManager;
import com.good.news.models.dto.articles.ArticleDto;
import com.good.news.models.entity.articles.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/api/v001/articles")
@AllArgsConstructor
public class ArticleController {

    private final ArticleManager articleManager;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("articles", articleManager.findAll());
        return "articles/articles";
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("article", articleManager.findById(id));
        return "articles/article";
    }

    @GetMapping(value = "/create")
    public String getFormForCreateArticle(@ModelAttribute(value = "article") Article article) {
        return "articles/create";
    }

    @GetMapping(value = "/{id}/update")
    public String getFormForUpdateArticle(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("article", articleManager.findById(id));
        return "articles/update";
    }

    @PutMapping(value = "/{id}")
    public String update(@ModelAttribute(value = "article") @Valid ArticleDto article,
                         BindingResult bindingResult,
                         @PathVariable(value = "id") Long id,
                         @RequestBody(required = false) MultipartFile file) {
        if (bindingResult.hasErrors()) return "/articles/update";
        articleManager.update(id, article, file);
        return "redirect:/api/v001/articles/" + id;
    }

    @PostMapping
    public String save(@ModelAttribute(value = "article") @Valid ArticleDto article,
                       BindingResult bindingResult,
                       @RequestBody MultipartFile file) {
        if (bindingResult.hasErrors()) return "/articles/create";
        articleManager.save(article, file);
        return "redirect:/api/v001/articles";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        articleManager.deleteById(id);
        return "redirect:/api/v001/articles";
    }
}
