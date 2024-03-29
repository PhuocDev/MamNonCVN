package com.example.mamnoncvn.feedback.controller;

import com.example.mamnoncvn.BlogManager.service.BlogService;
import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import com.example.mamnoncvn.feedback.service.FeedbackService;
import com.example.mamnoncvn.mailSender.EmailService;
import com.example.mamnoncvn.mailSender.Mail;
import com.example.mamnoncvn.users.entity.AdminEmail;
import com.example.mamnoncvn.users.repository.AdminEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;


    @GetMapping("/createDB")
    public List<Feedback> getAllCmt() {
        for (int i = 1; i < 10; i++) {
            CreateFeedbackRequest createFeedbackRequest =
                    new CreateFeedbackRequest(
                            "Customer " + i,
                            "Email" + i + "@gmail.com",
                            "0986"+i*123456,
                            "Content for " + i*123
                    );
            feedbackService.save(createFeedbackRequest);
        }
        return feedbackService.getAll();
    }

    @GetMapping(path = "/")
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<Feedback> feedbackList = feedbackService.getAll();
        if (keyword != null) {
            feedbackList = feedbackService.findAllByKeyword(keyword);
        }
        model.addAttribute("feedbackList", feedbackList);

        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest();
        model.addAttribute("createFeedbackRequest", createFeedbackRequest);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);

        return "/admin/feedback";
    }

    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewFeedback(Model model,@Valid @ModelAttribute("createFeedbackRequest") CreateFeedbackRequest createFeedbackRequest) {

        feedbackService.save(createFeedbackRequest);
        return "redirect:/admin/feedback/";
    }
    @Autowired
    AdminEmailRepository adminEmailRepository;
    @Autowired
    EmailService emailService;
    @PostMapping(path = "/addFromClient",  consumes = "application/x-www-form-urlencoded")
    public String addNewFeedbackFromClient(Model model,@Valid @ModelAttribute("createFeedbackRequest") CreateFeedbackRequest createFeedbackRequest) {

        feedbackService.save(createFeedbackRequest);
        try {
            List<AdminEmail> adminEmailList = adminEmailRepository.findAll();
            Mail mail = new Mail();
            mail.setSubject("Một khách hàng đang cần liên hệ");
            for (int i =0; i< adminEmailList.size();i++){
                mail.setRecipient(adminEmailList.get(i).getEmail());
                mail.setAttachment(null);
                mail.setMsgBody("Thông tin khách hàng" +
                        "\nTên khách hàng: " + createFeedbackRequest.getName()+
                        "\nEmail: " + createFeedbackRequest.getEmail() +
                        "\nSố điện thoại: " + createFeedbackRequest.getSoDienThoai()+
                        "\nNội dung: " + createFeedbackRequest.getContent() +
                        "\nNgày đăng kí: " + LocalDateTime.now()
                );
                emailService.sendSimpleMail(mail);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/client/";
    }

    @GetMapping("/deleteFeedback")
    public String deleteFeedback(@PathParam("id") Long id, Model model){
        feedbackService.deleteFeedbackById(id);
        return "redirect:/admin/feedback/";
    }

}
