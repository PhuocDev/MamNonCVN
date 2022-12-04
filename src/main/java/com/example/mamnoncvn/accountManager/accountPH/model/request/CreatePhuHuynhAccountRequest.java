package com.example.mamnoncvn.accountManager.accountPH.model.request;

import com.example.mamnoncvn.accountManager.roles.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePhuHuynhAccountRequest {

    @NotBlank(message = "username cannot be null/blank")
    private String username;

    @NotBlank(message = "password cannot be null/blank")
    private String password;


    @NotBlank(message = "ten phu huynh cannot be null/blank")
    private String tenPhuHuynh;

    @Size(max = 30)
    @Email
    private String email;

    private String soDienThoai;

    private String diaChi;

    @NotNull(message = "student id cannot be null")
    private Long studentId;

    private boolean isEnable;
}
