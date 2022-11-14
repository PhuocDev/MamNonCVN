package com.example.mamnoncvn.controllers;
import com.example.mamnoncvn.GiaoVienCVN.Models.request.CreateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.service.GiaoVienService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String hello(Model model) {
        return "index";
    }
    @GetMapping("/test")
    public String test() {
        return "layout/admin_layout";
    }
    @GetMapping("/student")
    public String student() {
        return "admin/student";
    }


    @Autowired
    GiaoVienService giaoVienService;

    @GetMapping("/teacher")
    public String teacherManagement(Model model){
        List<GiaoVien> giaoVienList = giaoVienService.getAllGV();
        model.addAttribute("giaoVienList", giaoVienList);
        return "admin/giaovien";
    }
    @GetMapping("/addGV")
    public String addNewGV(@RequestParam String hoten, @RequestParam String sdt,@RequestParam String address,
                           @RequestParam String email, @RequestParam Boolean trangThai)
    {
        CreateGiaoVienRequest giaoVienRequest = new CreateGiaoVienRequest(hoten, address, sdt,email,trangThai);
        giaoVienService.addNewGiaoVien(giaoVienRequest);
        return "redirect:/teacher";
    }
    @GetMapping("/deleteGV")
    public String deleteGV(@RequestParam Long id) {
        giaoVienService.deleteGiaoVienById(id);
        return "redirect:/teacher";
    }
}
