package com.example.mamnoncvn.customer.models.request;

import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateCustomerRequest {
    @NotNull
    @NotBlank(message = "Tên bé cannot be blank")
    @Column(name = "ten_be")
    private String tenBe;

    @NotNull
    @Column(name = "tuoi_be")
    private int tuoiBe;

    @NotNull
    @Column(name = "ten_phu_huynh")
    private String tenPhuHuynh;

    @NotNull
    @Column(name = "nghe_nghiep")
    private String ngheNghiep;

    @NotNull
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ghi_chu")
    private String ghiChu;

    public CreateCustomerRequest() {

    }
    public CreateCustomerRequest(String tenBe, int tuoiBe, String tenPhuHuynh, String ngheNghiep, String soDienThoai, String email, String diaChi, String ghiChu) {
        this.tenBe = tenBe;
        this.tuoiBe = tuoiBe;
        this.tenPhuHuynh = tenPhuHuynh;
        this.ngheNghiep = ngheNghiep;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }
}
