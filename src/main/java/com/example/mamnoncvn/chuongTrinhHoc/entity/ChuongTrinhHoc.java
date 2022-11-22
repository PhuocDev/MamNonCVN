package com.example.mamnoncvn.chuongTrinhHoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "chuong_trinh_hoc")
@Data
@AllArgsConstructor
public class ChuongTrinhHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ten_cth")
    @NotBlank(message = "Name of TKB can not be null")
    private String tenCTH;

    @Column(name = "description")
    private String description;

    @Column(name = "anh_bia")
    private String anhBia;

    @Column(name = "ngay_bat_dau")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayKetThuc;

    @Column(name = "noi_dung")
    @NotNull
    private String noiDung;

    @Column(name = "ngay_dang")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayDang;

    @Column(name = "status")
    @NotNull
    private boolean status;

    @NotNull()
    @Column(name = "ma_lop")
    private Long maLop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChuongTrinhHoc() {

    }
}
