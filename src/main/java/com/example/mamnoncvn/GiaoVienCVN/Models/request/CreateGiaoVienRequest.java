package com.example.mamnoncvn.GiaoVienCVN.Models.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Setter
@Getter
public class CreateGiaoVienRequest {
    @NotBlank(message = "Name is mandatory")
    private String hoTen;

    @NotNull
    @NotBlank(message = "Dia Chi can not be blank")
    private String diaChi;


    @Pattern(regexp="(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "Số điện thoại không hợp lệ!")
    private String soDienThoai;

    @NotBlank(message = "Email trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotNull
    private boolean status;

    public CreateGiaoVienRequest(String s, String s1, String s2, String email, boolean b) {
        this.hoTen = s;
        this.diaChi = s1;
        this.soDienThoai = s2;
        this.email = email;
        this.status = b;
    }


    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
