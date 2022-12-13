package com.example.mamnoncvn.client.controller;

import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.service.ChuongTrinhHocService;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ChuongTrinhHocService chuongTrinhHocService;
    @GetMapping(path = {"/", "/trangchu"})
    public String trangchu() {
        return "client/trangchu";
    }

    //đã hoàn thành
    @GetMapping("/tuvan")
    public String tuvan(Model model) {
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        model.addAttribute("createCustomerRequest", createCustomerRequest);
        return "client/tuvan";
    }

    @GetMapping("/chuongtrinhhoc")
    public String chuongtrinhhoc(Model model, @RequestParam(required = false) String keyword) {
        List<ChuongTrinhHoc> chuongTrinhHocList = chuongTrinhHocService.getAll();
        if (keyword != null) {
            chuongTrinhHocList = chuongTrinhHocService.findAllByKeyword(keyword);
        }
        model.addAttribute("chuongTrinhHocList", chuongTrinhHocList);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/chuongtrinhhoc";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        return "client/blog";
    }
    @GetMapping("/blogDetail")
    public String blogDetail(Model model) {
        return "client/blogDetail";
    }
    @GetMapping("/viewCthDetail")
    public String viewCthDetail(Model model, @PathParam("id") Long id) {
        ChuongTrinhHoc chuongTrinhHoc = chuongTrinhHocService.findChuongTrinhHocByID(id);
        if (chuongTrinhHoc == null)  throw new NotFoundException("Cannot found CTH id: " + id);
        model.addAttribute("chuongtrinhhoc", chuongTrinhHoc);
        return "client/cthDetail";
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


}
