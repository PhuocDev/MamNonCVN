package com.example.mamnoncvn.feedback.models.mapper;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;

import java.time.LocalDate;

public class FeedbackMapper {
    public static Feedback convertRequestCreateToEntity(CreateFeedbackRequest createdFeedbackRequest) {
        Feedback feedback = new Feedback();

        feedback.setName(createdFeedbackRequest.getName());
        feedback.setEmail(createdFeedbackRequest.getEmail());
        feedback.setContent(createdFeedbackRequest.getContent());
        feedback.setDateCreated(LocalDate.now());
        feedback.setSoDienThoai(createdFeedbackRequest.getSoDienThoai());

        return feedback;
    }
}
