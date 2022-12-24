package com.example.mamnoncvn.users.Models.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdatePasswordRequest {

    @NotNull
    private Long userId;
    @NotNull
    private String oldPassword;

    @NotNull(message = "password cannot be null")
    private String newPassword;
}
