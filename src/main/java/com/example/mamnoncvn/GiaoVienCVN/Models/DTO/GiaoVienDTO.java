package com.example.mamnoncvn.GiaoVienCVN.Models.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GiaoVienDTO {

    Long id;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private boolean status;
}
