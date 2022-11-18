package com.example.mamnoncvn.feedback.service;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;

import java.util.List;

public interface FeedbackService {

    public List<Feedback>  getAllFeedback();
    public Feedback addFeedback(CreateFeedbackRequest feedback);
    public boolean deleteFeedback(long id);
}
