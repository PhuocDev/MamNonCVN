package com.example.mamnoncvn.ClassManager.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "class")
public class CVN_Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "name cannot be blank")
    private String name;
    @Column(name = "age")
    @Min(value = 0)
    private int age;

    @Column(name = "date_started")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateStarted;

    @Column(name = "date_ended")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnded;

    @Column(name = "tuition")
    @NotNull(message = "tuition cannot be null")
    private Long tuition;

    @Column(name ="total_student" )
    @Min(value = 0)
    @NotNull(message = "total cannot be null")
    private int totalStudent;

    @Column(name = "ten_giao_vien1")
    @NotNull(message = "giao vien 1 cannot be null")
    private String tenGiaoVien1;

    @Column(name = "ten_giao_vien2")
    private String tenGiaoVien2;

    @Column(name = "status")
    @NotNull
    private boolean status;

    public CVN_Class() {

    }

    public CVN_Class(String name, int age, LocalDate dateStarted, LocalDate dateEnded, Long tuition, int totalStudent, String tenGiaoVien1, String tenGiaoVien2, boolean status) {
        this.name = name;
        this.age = age;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.tuition = tuition;
        this.totalStudent = totalStudent;
        this.tenGiaoVien1 = tenGiaoVien1;
        this.tenGiaoVien2 = tenGiaoVien2;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(LocalDate dateEnded) {
        this.dateEnded = dateEnded;
    }

    public Long getTuition() {
        return tuition;
    }

    public void setTuition(Long tuition) {
        this.tuition = tuition;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    public String getTenGiaoVien1() {
        return tenGiaoVien1;
    }

    public void setTenGiaoVien1(String tenGiaoVien1) {
        this.tenGiaoVien1 = tenGiaoVien1;
    }

    public String getTenGiaoVien2() {
        return tenGiaoVien2;
    }

    public void setTenGiaoVien2(String tenGiaoVien2) {
        this.tenGiaoVien2 = tenGiaoVien2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
