package com.example.mamnoncvn.users.Models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotBlank(message = "username can not be blank")
    private String username;

    @NotBlank(message = "password can not be blank/null")
    private String password;

    private String email;

    @NotBlank(message = "so dien thoai can not be null/blank")
    private String soDienThoai;

    @NotNull(message = "status cannot be null")
    private boolean status;

    @NotNull(message = "ma chuc vu can not be null")
    private Long maChucVu;

}
