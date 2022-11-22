package com.example.mamnoncvn.feedback.controller;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import com.example.mamnoncvn.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@RestController
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping({"/all", "/"})
    public String feedback(Model model, @RequestParam(name = "name", required = false) String name,
                           @RequestParam("page")Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Feedback> resultPage = null;
        if(StringUtils.hasText(name)) {
            resultPage = feedbackService.findByTenNguoiGuiContaining(name,pageable);
            model.addAttribute("name", name);
        } else {
            resultPage = feedbackService.getPageFeedback(pageable);
        }
        int totalPages = resultPage.getTotalPages();
        if(totalPages >0) {
            int start = Math.max(1,currentPage - 2);
            int end = Math.min(currentPage + 2, totalPages);
//            if(totalPages > 5) {
//                if(end == totalPages){
//                    start = end - 5;
//                } else if (start == 1) {
//                    end = start +5;
//                }
//            }
            List<Integer> pageNumber = IntStream.rangeClosed(start,end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumber", pageNumber);
        }
        model.addAttribute("feedback", resultPage);
        return "admin/feedback";
    }

    @GetMapping("/view-add")
    public ModelAndView viewAddProduct(Feedback feedback) {
        return new ModelAndView("feedback");
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
