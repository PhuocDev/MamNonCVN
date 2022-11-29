package com.example.mamnoncvn.comment.entity;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be null/blank")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "content")
    @NotBlank(message = "content of a comment cannot be null/blank")
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_created")
    private LocalDate dateCreated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blog_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @NotNull(message = "ma blog cannot be null")
    private Blog blog;
    public Comment() {

    }

    public Comment(String name, String email, String content, LocalDate dateCreated, Blog blog) {
        this.name = name;
        this.email = email;
        this.content = content;
        this.dateCreated = dateCreated;
        this.blog = blog;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
