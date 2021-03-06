package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.Services.CategoryRepo;
import com.codeup.codeupblog.Services.PostRepo;
import com.codeup.codeupblog.Services.UserRepo;
import com.codeup.codeupblog.model.Category;
import com.codeup.codeupblog.model.Post;
import com.codeup.codeupblog.Services.PostService;
import com.codeup.codeupblog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    public PostRepo postRepo;

    @Autowired
    public CategoryRepo categoryRepo;

    @Autowired
    public UserRepo userRepo;


    @GetMapping("/posts")
    public String showPosts(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        return "index";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryRepo.findAll());
        return "create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post, @RequestParam(value="categories", required=false) List<Category> cats) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userRepo.findOne(loggedInUser.getId()));
        post.setCategories(cats);
        postRepo.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model) {

        model.addAttribute("post", postRepo.findOne(id));

        return "post";
    }
}
