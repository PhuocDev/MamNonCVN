package com.example.mamnoncvn.users.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    @NotBlank(message = "Username cannot be blank/null")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "password cannot be blank/null")
    private String password;
    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "status")
    @NotNull(message = "status cannot be null")
    private boolean status;

    @Column(name = "user_role")
    @NotNull(message = "role can not be null")
    String role;
    public User() {

    }

    public User( String username, String password, String email, String soDienThoai, boolean status, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.status = status;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
