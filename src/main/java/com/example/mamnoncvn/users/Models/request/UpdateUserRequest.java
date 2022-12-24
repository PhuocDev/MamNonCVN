package com.example.mamnoncvn.users.Models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    @NotNull(message = "ID of user cannot be null")
    private Long id;

    @NotBlank(message = "username can not be blank")
    private String username;

    @NotBlank(message = "password can not be blank/null")
    private String password;

    private String email;

    private String soDienThoai;

    private boolean status;

    private String role;
}
