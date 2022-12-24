package com.example.mamnoncvn.dashboard.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    public Report getCurrentReport(Report report) {
        try {
            report.setTotalStudent(reportRepository.getTotalStudent());
            report.setTotalBlogs(reportRepository.getTotalBlogs());
            report.setPotentailCustomer(reportRepository.getTotalPotentialCustomer());
            report.setTotalStudentThisMonth(reportRepository.getTotalStudentThisMonth());
            report.setSupportRequest(reportRepository.getTotalSupportRequestThisMonth());
            report.setTotalTeacher(reportRepository.getTotalTeacher());
            report.setMonthlyIncome(reportRepository.getTotalIncomeThisMonth().toString());
            System.out.println(report.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return report;
    }
}
