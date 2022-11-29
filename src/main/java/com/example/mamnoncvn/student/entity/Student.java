package com.example.mamnoncvn.student.entity;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Student name cannot be null or blank")
    @Column(name = "ten_hoc_sinh")
    private String tenHocSinh;

    @NotNull(message = "Date of birth should not be null")
    @Column(name = "ngay_sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "chieu_cao")
    private int chieuCao;
    @Column(name = "can_nang")
    private int canNang;

    @Column(name = "ten_phu_huynh")
    @NotBlank(message = "ten phu huynh cannot be null/blank")
    private String tenPhuHuynh;

    @Column(name = "so_dien_thoai")
    @NotBlank(message = "So dien thoai cannot be null/blank")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    @NotNull
    private String diaChi;

    @Column(name = "ngay_nhap_hoc")
    @NotNull(message = "ngay nhap hoc cannot be null")
    private LocalDate ngayNhapHoc;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore @NotNull(message = "ma lop cannot be null")
    private CVN_Class cvn_class;

    @Column(name = "status")
    @NotNull
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student() {

    }

    public Student(String tenHocSinh, LocalDate ngaySinh, String gioiTinh, int chieuCao, int canNang, String tenPhuHuynh, String soDienThoai, String email, String diaChi, LocalDate ngayNhapHoc, String ghiChu, CVN_Class cvn_class, Boolean status) {
        this.tenHocSinh = tenHocSinh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.tenPhuHuynh = tenPhuHuynh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayNhapHoc = ngayNhapHoc;
        this.ghiChu = ghiChu;
        this.cvn_class = cvn_class;
        this.status = status;
    }
}
