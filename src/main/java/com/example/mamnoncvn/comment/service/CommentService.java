package com.example.mamnoncvn.comment.service;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.service.BlogService;
import com.example.mamnoncvn.comment.Models.mapper.CommentMapper;
import com.example.mamnoncvn.comment.Models.requests.CreateCommentRequest;
import com.example.mamnoncvn.comment.entity.Comment;
import com.example.mamnoncvn.comment.repository.CommentRepository;
import com.example.mamnoncvn.exception.BadRequestException;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BlogService blogService;

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment save(CreateCommentRequest createCommentRequest) {
        Comment comment = CommentMapper.convertRequestCreateToEntity(createCommentRequest);
        Blog blog = blogService.findBlogById(Long.valueOf(createCommentRequest.getBlogId()));
        comment.setBlog(blog);
        commentRepository.save(comment);
        return comment;
    }

    public void deleteCommentById(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else throw new NotFoundException("Not found Comment id: " + id);
    }


    public Comment findCommentByID(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new NotFoundException("Not found Comment id: " + id);
        }
        return commentRepository.findById(id).get();
    }

    public List<Comment> findAllByKeyword(String keyword) {
        return commentRepository.findAllByKeyword(keyword);
    }
}
