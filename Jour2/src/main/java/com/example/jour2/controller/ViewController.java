package com.example.jour2.controller;

import com.example.jour2.models.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class ViewController {

    @GetMapping
    public String showForm(User user) {
        return "view";
    }

    @PostMapping("/welcome")
    public String welcome(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "view";
        }

        String message = "Welcome, " + user.getName() + "! Your age is " + user.getAge() + ".";
        model.addAttribute("welcomeMessage", message);
        return "welcome";
    }
}

