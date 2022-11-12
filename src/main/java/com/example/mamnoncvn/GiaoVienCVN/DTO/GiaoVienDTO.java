package com.example.mamnoncvn.GiaoVienCVN.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GiaoVienDTO {

    @NotBlank(message = "Name is mandatory")
    private String hoTen;

    @NotNull
    @NotBlank(message = "Dia Chi can not be blank")
    private String diaChi;

    @NotNull
    private String soDienThoai;

    @NotNull
    private boolean status;


    public GiaoVienDTO(String hoTen, String diaChi, String soDienThoai, boolean status) {
        this.diaChi = diaChi;
        this.status = status;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }
    public GiaoVienDTO() {

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
