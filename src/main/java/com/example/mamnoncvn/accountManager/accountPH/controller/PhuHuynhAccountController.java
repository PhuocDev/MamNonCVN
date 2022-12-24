package com.example.mamnoncvn.accountManager.accountPH.controller;

import com.example.mamnoncvn.accountManager.accountPH.entity.PhuHuynhAccount;
import com.example.mamnoncvn.accountManager.accountPH.model.request.CreatePhuHuynhAccountRequest;
import com.example.mamnoncvn.accountManager.accountPH.model.request.UpdatePhuHuynhAccountRequest;
import com.example.mamnoncvn.accountManager.accountPH.service.PhuHuynhAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/admin/phuhuynh")
public class PhuHuynhAccountController {
    @Autowired
    PhuHuynhAccountService phuHuynhAccountService;
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/createDB")
    public List<PhuHuynhAccount> createDB() {
        for (int i = 1; i < 5; i++) {
            CreatePhuHuynhAccountRequest createPhuHuynhAccountRequest
                    = new CreatePhuHuynhAccountRequest(
                            "user" + i,
                            "password"+i,
                            "Ho va ten " + i,
                            "email"+i+"@gmail.com",
                            "0987"+ i*654321,
                            "dia chi " + i,
                            123L,
                            true
            );
            phuHuynhAccountService.insertNewPHAccount(createPhuHuynhAccountRequest);
        }
        return phuHuynhAccountService.getAll();
    }

    @GetMapping(path = {"/all", "/"})
    public String phuHuynhManagement(Model model, @RequestParam(required = false) String keyword){
        List<PhuHuynhAccount> phuHuynhAccountList = phuHuynhAccountService.getAll();
        if (keyword != null) {
            phuHuynhAccountList = phuHuynhAccountService.findAllByKeyword(keyword);
        }
        model.addAttribute("phuHuynhAccountList", phuHuynhAccountList);
        CreatePhuHuynhAccountRequest createPhuHuynhAccountRequest = new CreatePhuHuynhAccountRequest();
        model.addAttribute("createPhuHuynhRequest", createPhuHuynhAccountRequest);
        UpdatePhuHuynhAccountRequest updatePhuHuynhAccountRequest = new UpdatePhuHuynhAccountRequest();
        model.addAttribute("updatePhuHuynhRequest", updatePhuHuynhAccountRequest);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "admin/phuhuynh";
    }

    //lưu ý phải sử dụng @ModelAttribute để phân biệt các request body
    @PostMapping(path = "/addPH", consumes = "application/x-www-form-urlencoded")
    public String addNewPHPost(@Valid @ModelAttribute("createPhuHuynhRequest") CreatePhuHuynhAccountRequest createPhuHuynhAccountRequest)
    {
        //CreatePhuHuynhAccountRequest phuHuynhAccountRequest = new CreatePhuHuynhAccountRequest(hoten, address, sdt,email,trangThai);
        phuHuynhAccountService.insertNewPHAccount(createPhuHuynhAccountRequest);
        return "redirect:/admin/phuhuynh/all";
    }
    @PostMapping(path = "/updatePH", consumes = "application/x-www-form-urlencoded")
    public String updatePH(@Valid @ModelAttribute("updatePhuHuynhRequest") UpdatePhuHuynhAccountRequest updatePhuHuynhAccountRequest)
    {
        phuHuynhAccountService.updatePHAccount(updatePhuHuynhAccountRequest);
        return "redirect:/admin/phuhuynh/all";
    }

    @GetMapping("/deletePH")
    public String deletePH(@RequestParam Long id) {
        phuHuynhAccountService.deletePHaccountId(id);
        return "redirect:/admin/phuhuynh/all";
    }
}
