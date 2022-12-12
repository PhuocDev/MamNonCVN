package com.example.mamnoncvn.dashboard;

import com.example.mamnoncvn.dashboard.report.Report;
import com.example.mamnoncvn.dashboard.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @Autowired
    ReportService reportService;

    @GetMapping(path = {"/", "/dashboard"})
    public String dashboardIndex(Model model){
        Report report = new Report();
        report = reportService.getCurrentReport(report);

        model.addAttribute("report", report);

        return "admin/dashboard";
    }
}
