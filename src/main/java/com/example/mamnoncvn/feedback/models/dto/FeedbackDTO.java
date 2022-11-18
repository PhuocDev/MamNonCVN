package com.example.mamnoncvn.feedback.models.dto;

public class FeedbackDTO {
    private Long id;
    private String noiDung;
    private String tenNguoiGui;
    private String email;
    private String soDT;

    public FeedbackDTO() {
    }

    public FeedbackDTO(Long id, String noiDung, String tenNguoiGui, String email, String soDT) {
        this.id = id;
        this.noiDung = noiDung;
        this.tenNguoiGui = tenNguoiGui;
        this.email = email;
        this.soDT = soDT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
