package com.example.mamnoncvn.feedback.service;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FeedbackService {

    public List<Feedback>  getAllFeedback();
    public Feedback addFeedback(CreateFeedbackRequest feedback);

    Page<Feedback> findByTenNguoiGuiContaining(String name, Pageable pageable);

    Page<Feedback> getPageFeedback (Pageable pageable);

    public boolean deleteFeedback(long id);
}
