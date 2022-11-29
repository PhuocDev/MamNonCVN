package com.example.mamnoncvn.comment.Models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank(message = "Name cannot be null/blank")
    private String name;

    private String email;

    @NotBlank(message = "content of a comment cannot be null/blank")
    private String content;

    @NotBlank(message = "blog id cannot be blank/null")
    private String blogId;

}
