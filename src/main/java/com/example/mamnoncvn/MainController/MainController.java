package com.example.mamnoncvn.MainController;

import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.standard.expression.Fragment;


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

    @GetMapping("/test")
    public String fragmentDemo(Model model) {
        return "client/demo";
    }

    @GetMapping("/studentDemo")
    public String student() {
        return "admin/student";
    }
}
