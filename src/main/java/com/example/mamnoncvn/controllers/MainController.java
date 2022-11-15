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


    @Autowired
    GiaoVienService giaoVienService;

    @GetMapping("/teacher")
    public String teacherManagement(Model model){
        List<GiaoVien> giaoVienList = giaoVienService.getAllGV();
        model.addAttribute("giaoVienList", giaoVienList);
        CreateGiaoVienRequest giaoVienRequest = new CreateGiaoVienRequest();
        model.addAttribute("giaovienRequest", giaoVienRequest);
        UpdateGiaoVienRequest updateGiaoVienRequest = new UpdateGiaoVienRequest();
        model.addAttribute("updateGiaovienRequest", updateGiaoVienRequest);
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
    //lưu ý phải sử dụng @ModelAttribute để phân biệt các request body
    @PostMapping(path = "/addGV", consumes = "application/x-www-form-urlencoded")
    public String addNewGVPost(@Valid @ModelAttribute("giaovienRequest") CreateGiaoVienRequest giaoVienRequest)
    {
        //CreateGiaoVienRequest giaoVienRequest = new CreateGiaoVienRequest(hoten, address, sdt,email,trangThai);
        giaoVienService.addNewGiaoVien(giaoVienRequest);
        return "redirect:/teacher";
    }
    @PostMapping(path = "/updateGV", consumes = "application/x-www-form-urlencoded")
    public String updateGV(@Valid @ModelAttribute("updateGiaovienRequest") UpdateGiaoVienRequest updateGiaoVienRequest)
    {
        //CreateGiaoVienRequest giaoVienRequest = new CreateGiaoVienRequest(hoten, address, sdt,email,trangThai);
        giaoVienService.updateGiaoVien(updateGiaoVienRequest);
        return "redirect:/teacher";
    }
    @GetMapping("/deleteGV")
    public String deleteGV(@RequestParam Long id) {
        giaoVienService.deleteGiaoVienById(id);
        return "redirect:/teacher";
    }
}
