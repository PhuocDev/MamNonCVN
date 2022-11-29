package com.example.mamnoncvn.student.models.request;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateStudentRequest {
    @NotBlank(message = "Student name cannot be null or blank")
    private String tenHocSinh;

    @NotNull(message = "Date of birth should not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngaySinh;

    private String gioiTinh;
    private int chieuCao;

    private int canNang;


    @NotBlank(message = "ten phu huynh cannot be null/blank")
    private String tenPhuHuynh;


    @NotBlank(message = "So dien thoai cannot be null/blank")
    private String soDienThoai;

    private String email;

    @NotNull(message = "dia chi cannot be null")
    private String diaChi;
    @NotNull(message = "ngay nhap hoc cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayNhapHoc;


    private String ghiChu;

    @NotNull(message = "ma lop cannot be null")
    private String maLop;

    @NotNull
    private Boolean status;

    public CreateStudentRequest() {
    }

    @Override
    public String toString() {
        return "CreateStudentRequest{" +
                "tenHocSinh='" + tenHocSinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", chieuCao=" + chieuCao +
                ", canNang=" + canNang +
                ", tenPhuHuynh='" + tenPhuHuynh + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", ngayNhapHoc=" + ngayNhapHoc +
                ", ghiChu='" + ghiChu + '\'' +
                ", maLop='" + maLop + '\'' +
                ", status=" + status +
                '}';
    }

    public CreateStudentRequest(String tenHocSinh, LocalDate ngaySinh, String gioiTinh, int chieuCao, int canNang, String tenPhuHuynh, String soDienThoai, String email, String diaChi, LocalDate ngayNhapHoc, String ghiChu, String maLop, Boolean status) {
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
        this.maLop = maLop;
        this.status = status;
    }
}
