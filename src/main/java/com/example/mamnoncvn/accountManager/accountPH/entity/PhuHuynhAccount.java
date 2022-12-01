package com.example.mamnoncvn.accountManager.accountPH.entity;

import com.example.mamnoncvn.accountManager.roles.ERole;
import com.example.mamnoncvn.accountManager.roles.Roles;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "phu_huynh_account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "so_dien_thoai")
        })
@Data
public class PhuHuynhAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    @NotBlank(message = "username cannot be null/blank")
    @Size(max = 10)
    private String username;

    @Column(name = "password")
    @NotBlank(message = "password cannot be null/blank")
    private String password;

    @Column(name = "ten_phu_huynh")
    @NotBlank(message = "ten phu huynh cannot be null/blank")
    private String tenPhuHuynh;

    @Column(name = "email")
    @Size(max = 50)
    @Email
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @NotNull(message = "student id cannot be null")
    private Long studentId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "ph_role",
            joinColumns = @JoinColumn(name = "phu_huynh_account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    @Column(name = "is_enable")
    private boolean isEnable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhuHuynhAccount(){
        this.roles.add(new Roles(ERole.ROLE_USER));
    }

    public PhuHuynhAccount(String username, String password, String tenPhuHuynh, String email, String soDienThoai, String diaChi, Long studentId, Set<Roles> roles, boolean isEnable) {
        this.username = username;
        this.password = password;
        this.tenPhuHuynh = tenPhuHuynh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.studentId = studentId;
        this.roles = roles;
        this.isEnable = isEnable;
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

    public String getTenPhuHuynh() {
        return tenPhuHuynh;
    }

    public void setTenPhuHuynh(String tenPhuHuynh) {
        this.tenPhuHuynh = tenPhuHuynh;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
