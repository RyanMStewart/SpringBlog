package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.Services.CategoryRepo;
import com.codeup.codeupblog.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriesController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/categories")
    public String getCategories(Model vModel) {
        vModel.addAttribute("cats", categoryRepo.findAll());
        return "categories";
    }

    @GetMapping("/categories/{id}")
    public String getOneCategory(@PathVariable long id, Model vModel) {
        Category cat = categoryRepo.findOne(id);
        vModel.addAttribute("cat", cat);
        vModel.addAttribute("posts", cat.getPosts());
        return "posts";
    }
}
