package com.example.springmvcurlmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/home"})
    public String sayHello(Model model){
        model.addAttribute("taglib", "Hello Spring MVC.");
        return "home";
    }
    @GetMapping({"/hello"})
    public String saySpring(Model model){
        model.addAttribute("taglib", "Say Spring MVC.");
        return "home";
    }
    @GetMapping("/hi")
    public String hiSpring(Model model){
        model.addAttribute("taglib", "Hi Spring MVC");
        return "home";
    }
}
