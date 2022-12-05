package com.example.mamnoncvn.login.controller;

import com.example.mamnoncvn.login.request.LoginRequest;
import com.example.mamnoncvn.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String loginPage(Model model){
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "admin/login";
    }

    @PostMapping(path = "/login",  consumes = "application/x-www-form-urlencoded")
    public String loginResult(Model model,@Valid @ModelAttribute("loginRequest") LoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername() + " " + loginRequest.getPassword());
        if (loginService.isLoginSuccess(loginRequest)) {
            return "redirect:/phuhuynh/";
        }
        else return "redirect:/auth/";
    }
}
