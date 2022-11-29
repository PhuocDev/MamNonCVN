package com.example.mamnoncvn.comment.Models.mapper;

import com.example.mamnoncvn.comment.Models.requests.CreateCommentRequest;
import com.example.mamnoncvn.comment.entity.Comment;

import java.time.LocalDate;

public class CommentMapper {
    public static Comment convertRequestCreateToEntity(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.setContent(createCommentRequest.getContent());
        comment.setEmail(createCommentRequest.getEmail());
        comment.setName(createCommentRequest.getName());
        comment.setDateCreated(LocalDate.now());
        return comment;
    }
}
