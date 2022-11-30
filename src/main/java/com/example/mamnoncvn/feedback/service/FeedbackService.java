package com.example.mamnoncvn.feedback.service;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.feedback.entity.Feedback;
import com.example.mamnoncvn.feedback.models.mapper.FeedbackMapper;
import com.example.mamnoncvn.feedback.models.request.CreateFeedbackRequest;
import com.example.mamnoncvn.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    public Feedback save(CreateFeedbackRequest createFeedbackRequest) {
        Feedback feedback = FeedbackMapper.convertRequestCreateToEntity(createFeedbackRequest);
        feedbackRepository.save(feedback);
        return feedback;
    }

    public void deleteFeedbackById(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
        } else throw new NotFoundException("Not found Feedback id: " + id);
    }


    public Feedback findFeedbackByID(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new NotFoundException("Not found Feedback id: " + id);
        }
        return feedbackRepository.findById(id).get();
    }

    public List<Feedback> findAllByKeyword(String keyword) {
        return feedbackRepository.findAllByKeyword(keyword);
    }
}
