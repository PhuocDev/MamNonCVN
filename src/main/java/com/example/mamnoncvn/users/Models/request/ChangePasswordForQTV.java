package com.example.mamnoncvn.users.Models.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChangePasswordForQTV {

    @NotNull (message = "username cannot be null")
    private String username;

    @NotNull(message = "old password cannot be null")
    private String oldPassword;

    @NotNull(message = "password cannot be null")
    private String newPassword;
}
