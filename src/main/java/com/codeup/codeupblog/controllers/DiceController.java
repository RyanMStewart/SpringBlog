package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String rollDice() {
        return "<ul>" +
                "<li><a href='/roll-dice/1'>1</a></li>" +
                "<li><a href='/roll-dice/1'>2</a></li>" +
                "<li><a href='/roll-dice/1'>3</a></li>" +
                "<li><a href='/roll-dice/1'>4</a></li>" +
                "<li><a href='/roll-dice/1'>5</a></li>" +
                "<li><a href='/roll-dice/1'>6</a></li>" +
                "</ul>";
    }

    @GetMapping("/roll-dice/{num}")
    @ResponseBody
    public String checkDice(@PathVariable Integer num) {
        int roll = new Random().nextInt(6) + 1;

        if (num == roll) {
            return "You guessed right";
        } else {
            return "Sorry, the number was " + num;
        }
    }
}
