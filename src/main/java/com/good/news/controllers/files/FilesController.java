package com.good.news.controllers.files;

import com.good.news.models.entity.articles.Article;
import com.good.news.services.articles.ArticlesService;
import com.good.news.services.files.FilesService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/api/v001/files")
public class FilesController {

    private final FilesService filesService;
    private final ArticlesService articlesService;

    public FilesController(FilesService filesService, ArticlesService articlesService) {
        this.filesService = filesService;
        this.articlesService = articlesService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestBody(required = false) MultipartFile file, Model model) {
        String pathFile = filesService.upload(file);
        model.addAttribute("fileName", pathFile);
        System.out.println(pathFile);
        return "redirect:/api/v001/articles/create";
    }

    @DeleteMapping
    public String delete(@PathVariable(value = "fileName") String fileName) {
        filesService.delete(fileName);
        return "redirect:/api/v001/articles";
    }

}