package com.example.mamnoncvn.comment.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.service.BlogService;
import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.comment.Models.requests.CreateCommentRequest;
import com.example.mamnoncvn.comment.entity.Comment;
import com.example.mamnoncvn.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    BlogService blogService;

    @GetMapping("/createDB")
    public List<Comment> getAllCmt() {
        for (int i = 1; i < 10; i++) {
            CreateCommentRequest createCommentRequest =
                    new CreateCommentRequest(
                            "Customer " + i,
                            "Email" + i + "@gmail.com",
                            "Content for " + i*123,
                            "32"
                    );
            commentService.save(createCommentRequest);
        }

        return commentService.getAll();
    }

    @GetMapping(path = "/")
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<Comment> commentList = commentService.getAll();
        if (keyword != null) {
            commentList = commentService.findAllByKeyword(keyword);
        }
        model.addAttribute("commentList", commentList);

        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        model.addAttribute("createCommentRequest", createCommentRequest);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);

        return "/admin/comment";
    }

    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewComment(Model model,@Valid @ModelAttribute("createCommentRequest") CreateCommentRequest createCommentRequest) {

        commentService.save(createCommentRequest);
        return "redirect:/comment/";
    }

    @GetMapping("/deleteComment")
    public String deleteComment(@PathParam("id") Long id, Model model){
        commentService.deleteCommentById(id);
        return "redirect:/comment/";
    }
}
