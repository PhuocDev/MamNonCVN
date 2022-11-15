package com.example.mamnoncvn.controllers;
import com.example.mamnoncvn.GiaoVienCVN.Models.request.CreateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.Models.request.UpdateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.service.GiaoVienService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping("/student")
    public String student() {
        return "admin/student";
    }

}
