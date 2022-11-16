package com.example.mamnoncvn.BlogManager.models.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateBlogRequest {

    @Column
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @NotBlank(message = "category cannot be blank")
    private String category;

    @NotBlank(message = "thumbnail cannot be blank")
    private String thumbnail;

    @NotBlank(message = "content cannot be blank")
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateCreated;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateModified;

    @NotBlank(message = "author cannot be blank")
    private String author;
}
