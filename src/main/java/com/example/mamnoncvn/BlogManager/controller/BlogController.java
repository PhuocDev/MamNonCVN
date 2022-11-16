package com.example.mamnoncvn.BlogManager.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.models.request.CreateBlogRequest;
import com.example.mamnoncvn.BlogManager.service.BlogService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/createDB")
    public String createDB(Model model) {
        Blog sampleData = new Blog("Blog title 1", "description 1", "category 1", "thumbnail link",
                "Sample content", LocalDate.now(), LocalDate.now(), "author 1");
        blogService.save(sampleData);

        return "admin/blog_admin";
    }


    @GetMapping(path = {"/", "/all"})
    public String showBlogs(Model model) {
        List<Blog> blogList = blogService.findAllBlogs();
        model.addAttribute("blogList", blogList);
        CreateBlogRequest createBlogRequest = new CreateBlogRequest();
        model.addAttribute("createBlogRequest", createBlogRequest);
        return "admin/blog_admin";
    }
}
