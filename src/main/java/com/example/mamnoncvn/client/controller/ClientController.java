package com.example.mamnoncvn.client.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.service.BlogService;
import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.service.ChuongTrinhHocService;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
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
    @Autowired
    BlogService blogService;


    @GetMapping(path = {"/", })
    public String trangchu(Model model) {
        //CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        //model.addAttribute("createFeedbackRequest", new CreateFeedbackRequest());
        return "client/trangchu";
    }

    //đã hoàn thành
    @GetMapping("/tuvan")
    public String tuvan(Model model) {
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        model.addAttribute("createCustomerRequest", createCustomerRequest);
        return "client/tuvan";
    }
    // đã hoàn thành
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
    @GetMapping("/viewCthDetail")
    public String viewCthDetail(Model model, @PathParam("id") Long id) {
        ChuongTrinhHoc chuongTrinhHoc = chuongTrinhHocService.findChuongTrinhHocByID(id);
        if (chuongTrinhHoc == null)  throw new NotFoundException("Cannot found CTH id: " + id);
        model.addAttribute("chuongtrinhhoc", chuongTrinhHoc);
        return "client/cthDetail";
    }


    @GetMapping("/blog_thongbao")
    public String blog(Model model, @RequestParam(required = false) String keyword) {
        List<Blog> blogList = blogService.findAllByCategory("thongbao");
        if (keyword != null) blogList = blogService.findAllInOneCategory("thongbao", keyword);
        model.addAttribute("blogList", blogList);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/blog";
    }
    @GetMapping("/blog_all")
    public String blogAll(Model model, @RequestParam(required = false) String keyword) {
        List<Blog> blogList = blogService.findAll();
        if (keyword != null) blogList = blogService.findAllBlogs(keyword);
        model.addAttribute("blogList", blogList);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "client/blog";
    }
    @GetMapping("/viewBlogDetail")
    public String viewBlogDetail(Model model, @PathParam("id") Long id) {
        Blog blog = blogService.findBlogById(id);
        if (blog == null)  throw new NotFoundException("Cannot found blog id: " + id);
        model.addAttribute("blog", blog);
        return "client/blogDetail";
    }



    @GetMapping("contact")
    public String contact(Model model){
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        return "client/contact";
    }
    @GetMapping("/gioithieu")
    public String gioithieu(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        return "client/gioithieu";
    }

    @GetMapping("/tuyensinh")
    public String tuyensinh() {
        return "client/tuyensinh";
    }
    @GetMapping("/dangcapnhat")
    public String dangcapnhat(Model model) {
        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);
        return "client/dangcapnhat";
    }


}
