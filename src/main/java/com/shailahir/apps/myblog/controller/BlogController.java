package com.shailahir.apps.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("title", "Shailendra's Personal Blog");
        return "index";
    }

    @GetMapping("/blog")
    public String getBlogPage(Model model) {
        model.addAttribute("title", "Shailendra's Personal Blog");
        return "blog";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model) {
        model.addAttribute("title", "Shailendra's Personal Blog");
        return "contact";
    }
}
