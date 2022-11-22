package com.example.mamnoncvn.BlogManager.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.models.request.CreateBlogRequest;
import com.example.mamnoncvn.BlogManager.models.request.UpdateBlogRequest;
import com.example.mamnoncvn.BlogManager.service.BlogService;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
        CreateBlogRequest sampleData = new CreateBlogRequest("Blog title 1", "description 1", "category 1", "thumbnail link",
                "Sample content", LocalDate.now(), LocalDate.now(), "author 1");
        blogService.save(sampleData);
        return "admin/blog_admin";
    }
    @GetMapping
    public String index(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        CreateBlogRequest createBlogRequest = new CreateBlogRequest();
        createBlogRequest.setDateCreated(LocalDate.now());
        createBlogRequest.setDateModified(LocalDate.now());
        UpdateBlogRequest updateBlogRequest = new UpdateBlogRequest();
        updateBlogRequest.setDateCreated(LocalDate.now());
        updateBlogRequest.setDateModified(LocalDate.now());
        model.addAttribute("createBlogRequest", createBlogRequest);
        model.addAttribute("updateBlogRequest", updateBlogRequest);
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "admin/blog_admin";
    }

    @GetMapping(path = {"/", "/all", })
    public String showBlogs(Model model, @RequestParam(required = false) String keyword) {
        List<Blog> blogList = blogService.findAll();
        if (keyword != null) blogList = blogService.findAllBlogs(keyword);
        model.addAttribute("blogList", blogList);
        CreateBlogRequest createBlogRequest = new CreateBlogRequest();
        createBlogRequest.setDateCreated(LocalDate.now());
        createBlogRequest.setDateModified(LocalDate.now());
        UpdateBlogRequest updateBlogRequest = new UpdateBlogRequest();
        updateBlogRequest.setDateCreated(LocalDate.now());
        updateBlogRequest.setDateModified(LocalDate.now());
        model.addAttribute("createBlogRequest", createBlogRequest);
        model.addAttribute("updateBlogRequest", updateBlogRequest);

        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "admin/blog_admin";
    }
    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public String addBlog(@Valid @ModelAttribute("createBlogRequest") CreateBlogRequest createBlogRequest){
        blogService.save(createBlogRequest);
        return "redirect:/blog/all";
    }
    @GetMapping("/viewBlog")
    public String showBlogAdmin(@PathParam("id") Long id, Model model) {
        Blog blog = blogService.findBlogById(id);
        if (blog == null ) throw new NotFoundException("Cannot found blog id: " + id);
        model.addAttribute("blog", blog);
        return  "admin/viewblog";
    }

    @GetMapping("/deleteBlog")
    public String deleteBlog(@PathParam("id") Long id, Model model){
        Blog blog = blogService.findBlogById(id);
        if (blog == null ) throw new NotFoundException("Cannot found blog id: " + id);
        blogService.deleteBlogById(id);
        return "redirect:/blog/all";
    }

    @PostMapping(path = "/updateBlog", consumes = "application/x-www-form-urlencoded")
    public String updateBlog(@Valid @ModelAttribute("updateBlogRequest") UpdateBlogRequest updateBlogRequest){
        blogService.update(updateBlogRequest);
        return "redirect:/blog/all";
    }
}
