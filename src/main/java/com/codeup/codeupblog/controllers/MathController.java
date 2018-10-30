package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addStuff(@PathVariable String num1, @PathVariable String num2) {
        int x = Integer.parseInt(num1);
        int y = Integer.parseInt(num2);
        int added = x + y;

        return String.valueOf(added);
    }
}
