package com.example.mamnoncvn.feedback.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFeedbackRequest {

    @NotBlank(message = "name cannot be blank")
    private String name;

    private String email;

    private String soDienThoai;

    @NotBlank(message = "content cannot be null/blank")
    private String content;

}
