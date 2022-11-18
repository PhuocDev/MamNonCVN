package com.example.mamnoncvn.feedback.controller;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import com.example.mamnoncvn.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all")
    public String getAllFeedback(Model model) {
        List<Feedback> feedback = feedbackService.getAllFeedback();
        model.addAttribute("feedback",feedback);
        return "admin/feedback";
    }


    @GetMapping("/view-add")
    public ModelAndView viewAddProduct(Feedback feedback) {
        return new ModelAndView("gggg");
    }


    @PostMapping("/add")
    public String addFeedback(@ModelAttribute("save") CreateFeedbackRequest feedback) {
         feedbackService.addFeedback(feedback);
         return "redirect:/feedback/view-add";
    }

    @GetMapping("/{id}")
    public String deleteFeedback(@PathVariable("id") long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/feedback/all";
    }
}
