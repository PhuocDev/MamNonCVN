package com.example.mamnoncvn.BlogManager.models.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateBlogRequest {
    @NotNull
    private Long id;
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
    private LocalDate dateCreated;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateModified;

    @NotBlank(message = "author cannot be blank")
    private String author;

    public UpdateBlogRequest(){
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();
    }


    public UpdateBlogRequest(String title, String description, String category, String thumbnail, String content, LocalDate dateCreated, String author) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateModified = LocalDate.now();
        this.author = author;
    }
}
