package com.example.mamnoncvn.BlogManager.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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
    @NotNull
    private LocalDate dateCreated;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateModified;

    @NotBlank(message = "author cannot be blank")
    private String author;
    public Blog() {
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();
    }
    public Blog(String title, String description, String category, String thumbnail, String content, LocalDate dateCreated, LocalDate dateModified, String author) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.author = author;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
