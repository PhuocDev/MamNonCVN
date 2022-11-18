package com.example.mamnoncvn.feedback.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maFeedback;
    @Column
    @NotEmpty
    private String noiDung;
    @Column
    @NotEmpty
    private String tenNguoiGui;
    @Column
    private String email;
    @Column
    private String soDT;
    @Column
    private LocalDate dateCreatedl;

    public Feedback() {
    }

    public Feedback(Long maFeedback, String noiDung, String tenNguoiGui, String email, String soDT, LocalDate dateCreatedl) {
        this.maFeedback = maFeedback;
        this.noiDung = noiDung;
        this.tenNguoiGui = tenNguoiGui;
        this.email = email;
        this.soDT = soDT;
        this.dateCreatedl = dateCreatedl;
    }

    public Long getMaFeedback() {
        return maFeedback;
    }

    public void setMaFeedback(Long maFeedback) {
        this.maFeedback = maFeedback;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenNguoiGui() {
        return tenNguoiGui;
    }

    public void setTenNguoiGui(String tenNguoiGui) {
        this.tenNguoiGui = tenNguoiGui;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public LocalDate getDateCreatedl() {
        return dateCreatedl;
    }

    public void setDateCreatedl(LocalDate dateCreatedl) {
        this.dateCreatedl = dateCreatedl;
    }
}
