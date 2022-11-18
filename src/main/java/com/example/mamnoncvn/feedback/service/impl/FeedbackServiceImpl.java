package com.example.mamnoncvn.feedback.service.impl;

import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.mapper.FeedbackMapper;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import com.example.mamnoncvn.feedback.repository.FeedbackRepositoty;
import com.example.mamnoncvn.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepositoty feedbackRepositoty;

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepositoty.findAll();
    }

    @Override
    public Feedback addFeedback(CreateFeedbackRequest createFeedbackRequest) {
            Feedback feedback = FeedbackMapper.toFeedback(createFeedbackRequest);
            feedbackRepositoty.save(feedback);

        return null;
    }

    @Override
    public boolean deleteFeedback(long id) {
        if(feedbackRepositoty.existsById(id)) {
            feedbackRepositoty.deleteById(id);
            return  true;
        }
        return false;
    }
}
