package com.example.mamnoncvn.feedback.models.mapper;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;

import java.time.LocalDate;

public class FeedbackMapper {

    public static Feedback toFeedback(CreateFeedbackRequest createFeedbackRequest) {
        Feedback feedback = new Feedback();
        feedback.setNoiDung(createFeedbackRequest.getNoiDung());
        feedback.setTenNguoiGui(createFeedbackRequest.getTenNguoiGui());
        feedback.setSoDT(createFeedbackRequest.getSoDT());
        feedback.setEmail(createFeedbackRequest.getEmail());
        feedback.setDateCreatedl(LocalDate.now());
        return feedback;
    }
}
