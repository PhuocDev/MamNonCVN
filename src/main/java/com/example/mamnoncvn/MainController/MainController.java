package com.example.mamnoncvn.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String hello(Model model) {
        return "layout/admin_layout";
    }
    @GetMapping("/test")
    public String test() {
        return "layout/admin_layout";
    }
    @GetMapping("/studentDemo")
    public String student() {
        return "admin/student";
    }
}
