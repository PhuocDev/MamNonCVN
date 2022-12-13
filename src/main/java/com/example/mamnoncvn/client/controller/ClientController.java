package com.example.mamnoncvn.client.controller;

import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    CustomerService customerService;
    @GetMapping(path = {"/", "/trangchu"})
    public String trangchu() {
        return "client/trangchu";
    }

    @GetMapping("/tuvan")
    public String tuvan(Model model) {
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        model.addAttribute("createCustomerRequest", createCustomerRequest);
        return "client/tuvan";
    }



    @GetMapping("/blog")
    public String blog(Model model) {
        return "client/blog";
    }
    @GetMapping("/blogDetail")
    public String blogDetail(Model model) {
        return "client/blogDetail";
    }
    @GetMapping("contact")
    public String contact(){
        return "client/contact";
    }
    @GetMapping("/gioithieu")
    public String gioithieu() {
        return "client/gioithieu";
    }

    @GetMapping("/tuyensinh")
    public String tuyensinh() {
        return "client/tuyensinh";
    }
    @GetMapping("/dangcapnhat")
    public String dangcapnhat() {
        return "client/dangcapnhat";
    }

    @GetMapping("/chuongtrinhhoc")
    public String chuongtrinhhoc() {
        return "client/chuongtrinhhoc";
    }
}
