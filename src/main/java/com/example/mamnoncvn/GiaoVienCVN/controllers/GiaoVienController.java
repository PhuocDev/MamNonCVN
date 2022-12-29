package com.example.mamnoncvn.GiaoVienCVN.controllers;
import com.example.mamnoncvn.GiaoVienCVN.models.request.*;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.service.GiaoVienService;
import com.example.mamnoncvn.users.Models.request.ChangePasswordForQTV;
import com.example.mamnoncvn.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/giaovien")
public class GiaoVienController {
    @Autowired
    GiaoVienService giaoVienService;

//    @GetMapping("/createDB")
//    public List<GiaoVien> createDB() {
//        for (int i = 1; i < 5; i++) {
//            CreateGiaoVienRequest sampleData = new CreateGiaoVienRequest("Nguyễn Hoàng A" + i*100, "Dia chi " + i+1, "0987" + i*123451, i*345 + "@gmail.com" , true);
//            giaoVienService.addNewGiaoVien(sampleData);
//        }
//        return giaoVienService.getAllGV();
//    }
    @GetMapping(path = {"/all", "/"})
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
        return "redirect:/admin/giaovien/all";
    }
    //lưu ý phải sử dụng @ModelAttribute để phân biệt các request body
    @PostMapping(path = "/addGV", consumes = "application/x-www-form-urlencoded")
    public String addNewGVPost(@Valid @ModelAttribute("giaovienRequest") CreateGiaoVienRequest giaoVienRequest)
    {
        //CreateGiaoVienRequest giaoVienRequest = new CreateGiaoVienRequest(hoten, address, sdt,email,trangThai);
        giaoVienService.addNewGiaoVien(giaoVienRequest);
        return "redirect:/admin/giaovien/all";
    }
    @PostMapping(path = "/updateGV", consumes = "application/x-www-form-urlencoded")
    public String updateGV(@Valid @ModelAttribute("updateGiaovienRequest") UpdateGiaoVienRequest updateGiaoVienRequest)
    {
        //CreateGiaoVienRequest giaoVienRequest = new CreateGiaoVienRequest(hoten, address, sdt,email,trangThai);
        giaoVienService.updateGiaoVien(updateGiaoVienRequest);
        return "redirect:/admin/giaovien/all";
    }
    @GetMapping("/deleteGV")
    public String deleteGV(@RequestParam Long id) {
        giaoVienService.deleteGiaoVienById(id);
        return "redirect:/admin/giaovien/all";
    }

    @GetMapping(path = "/changePasswordForQTV")
    public String updatePasswordForQTV(Model model){
        //for changing password for qtv
        ChangePasswordForQTV changePasswordForQTV = new ChangePasswordForQTV();
        model.addAttribute("changePasswordForQTV", changePasswordForQTV);
        return "admin/doiMatKhau";
    }
    @Autowired
    UserService userService;
    @PostMapping(path = "/changePasswordForQTVPost",  consumes = "application/x-www-form-urlencoded")
    public String updatePassword(Model model, @Valid @ModelAttribute("changePasswordForQTV") ChangePasswordForQTV changePasswordForQTV) throws Exception {
        //for changing password for qtv
        if (userService.updatePasswordForQTV(changePasswordForQTV)) {
            userDetailsServiceBean();
            return "redirect:/login?logout";
        } else return "error";
    }

    public UserDetailsService userDetailsServiceBean() throws Exception {
        // add users in List
        List<UserDetails> users = new ArrayList<UserDetails>();
        List<com.example.mamnoncvn.users.entity.User> userList = userService.getAll();
        for (com.example.mamnoncvn.users.entity.User account : userList) {
            System.out.println(account.getUsername() + " " + account.getPassword());
            users.add(User.withDefaultPasswordEncoder()
                    .username(account.getUsername())
                    .password(account.getPassword()).roles(account.getRole()).build());
        }
        users.add(User.withDefaultPasswordEncoder()
                .username("phuoc")
                .password("phuoc").roles("admin").build());
        return new InMemoryUserDetailsManager(users);
    }

}
