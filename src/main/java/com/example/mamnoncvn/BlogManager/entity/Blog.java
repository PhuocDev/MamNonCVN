package com.example.mamnoncvn.BlogManager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
@Data
public class Blog {
    private String title;
    private String description;
    private String category;

}
