package com.example.mamnoncvn.student.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentRequest {

    @NotNull(message = "id cannot be null")
    private Long id;

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
}
