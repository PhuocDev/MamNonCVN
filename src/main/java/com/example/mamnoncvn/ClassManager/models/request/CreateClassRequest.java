package com.example.mamnoncvn.ClassManager.models.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateClassRequest {
    @Column(name = "name")
    @NotBlank(message = "name cannot be blank")
    private String name;
    @Column(name = "age")
    @Min(value = 0)
    @NotNull(message = "age cannot be null")
    private int age;

    @Column(name = "date_started")
    @NotNull(message = "date cannot be null")
    private LocalDate dateStarted;

    @Column(name = "date_ended")
    private LocalDate dateEnded;

    @Column(name = "tuition")
    @NotNull(message = "tuition cannot be null")
    private Long tuition;

    @Column(name ="total_student" )
    @NotBlank(message = "total student cannot be blank")
    private int totalStudent;

    @Column(name = "ten_giao_vien1")
    @NotNull(message = "giao vien 1 cannot be null")
    private String tenGiaoVien1;

    @Column(name = "ten_giao_vien2")
    private String tenGiaoVien2;

    @Column(name = "status")
    @NotNull
    private boolean status;

    public CreateClassRequest() {

    }

    public CreateClassRequest(String name, int age, LocalDate dateStarted, LocalDate dateEnded, Long tuition, int totalStudent, String tenGiaoVien1, String tenGiaoVien2, boolean status) {
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

}
