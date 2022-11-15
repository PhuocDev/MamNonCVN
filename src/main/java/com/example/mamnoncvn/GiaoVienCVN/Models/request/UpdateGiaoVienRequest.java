package com.example.mamnoncvn.GiaoVienCVN.Models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateGiaoVienRequest {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String hoTen;

    @NotNull
    @NotBlank(message = "Dia Chi can not be blank")
    private String diaChi;


    @Pattern(regexp="(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "Số điện thoại không hợp lệ!")
    private String soDienThoai;

    @NotBlank(message = "Email trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    
    @NotNull
    private boolean status;
}
