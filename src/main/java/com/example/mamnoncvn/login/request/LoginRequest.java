package com.example.mamnoncvn.login.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class LoginRequest {
    @NotNull @NotBlank
    private String username;
    @NotNull @NotBlank
    private String password;
}
