package com.example.mamnoncvn.feedback.models.request;

import javax.validation.constraints.*;

public class CreateFeedbackRequest {

    @NotEmpty
    @NotBlank(message = "noidung can not be blank")
    private String noiDung;
    @NotEmpty
    @NotBlank(message = "tenNguoiGui can not be blank")
    private String tenNguoiGui;
    @Email(message = "Email không đúng định dạng")
    private String email;
    @Pattern(regexp="(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "Số điện thoại không hợp lệ!")
    private String soDT;



    public CreateFeedbackRequest(String noiDung, String tenNguoiGui, String email, String soDT) {
        this.noiDung = noiDung;
        this.tenNguoiGui = tenNguoiGui;
        this.email = email;
        this.soDT = soDT;
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
