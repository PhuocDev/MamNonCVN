package com.example.mamnoncvn.customer.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_dk")
    private LocalDate ngayDK;

    @NotNull
    private Boolean status;

    public Customer() {

    }

    public Customer(Long id, String tenBe, int tuoiBe, String tenPhuHuynh, String ngheNghiep, String soDienThoai, String email, String diaChi, String ghiChu, LocalDate ngayDK, Boolean status) {
        this.id = id;
        this.tenBe = tenBe;
        this.tuoiBe = tuoiBe;
        this.tenPhuHuynh = tenPhuHuynh;
        this.ngheNghiep = ngheNghiep;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
        this.ngayDK = ngayDK;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenBe() {
        return tenBe;
    }

    public void setTenBe(String tenBe) {
        this.tenBe = tenBe;
    }

    public int getTuoiBe() {
        return tuoiBe;
    }

    public void setTuoiBe(int tuoiBe) {
        this.tuoiBe = tuoiBe;
    }

    public String getTenPhuHuynh() {
        return tenPhuHuynh;
    }

    public void setTenPhuHuynh(String tenPhuHuynh) {
        this.tenPhuHuynh = tenPhuHuynh;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDate getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(LocalDate ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
