package com.codeup.codeupblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class IndexController {
    @GetMapping("/")
    @ResponseBody
    public String indexController() {
        return "Hello!";
    }
}