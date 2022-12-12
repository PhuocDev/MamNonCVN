package com.example.mamnoncvn.dashboard.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "report")
@Data
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "total_student")
    private int totalStudent;

    @Column(name = "total_student_this_month")
    private int totalStudentThisMonth;

    @Column(name = "support_request")
    private int supportRequest;

    @Column(name = "potential_customer")
    private int potentailCustomer;

    @Column(name = "total_blog")
    private int totalBlogs;

    @Column(name = "total_teacher")
    private int totalTeacher;
    @Column(name = "total_income_monthly")
    private String monthlyIncome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Report() {
        this.totalStudent = 0;
        this.totalStudentThisMonth = 0;
        this.supportRequest = 0;
        this.potentailCustomer = 0;
        this.totalBlogs = 0;
        this.totalTeacher = 0;
        this.monthlyIncome = "0";
    }
}
