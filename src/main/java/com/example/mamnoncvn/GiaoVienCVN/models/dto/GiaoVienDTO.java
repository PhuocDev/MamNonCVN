package com.example.mamnoncvn.GiaoVienCVN.models.dto;

import lombok.*;

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
