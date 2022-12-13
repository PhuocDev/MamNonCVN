package com.example.mamnoncvn.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping
    public String indexTrangchu(Model model){
        return "redirect:/client/";
    }
    @GetMapping("/")
    public String hello(Model model) {
        return "redirect:/client/";
    }

    @GetMapping("/studentDemo")
    public String student() {
        return "admin/student";
    }
}
