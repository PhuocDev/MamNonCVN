package com.example.mamnoncvn.GiaoVienCVN.entity;

import com.example.mamnoncvn.GiaoVienCVN.models.dto.GiaoVienDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "giaovien")
public class GiaoVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "ho_ten")
    private String hoTen;


    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private boolean status;

    public GiaoVien(GiaoVienDTO giaoVienDTO) {
        this.diaChi = giaoVienDTO.getDiaChi();
        this.hoTen = giaoVienDTO.getHoTen();
        this.soDienThoai = giaoVienDTO.getSoDienThoai();
        this.status = giaoVienDTO.isStatus();
    }

    public GiaoVien() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
