package com.bobrowski.IssTrackingApp.web.controllers;

import com.bobrowski.IssTrackingApp.biz.model.ReportISS;
import com.bobrowski.IssTrackingApp.repositories.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reports-position")
public class ReportsController {
    @Autowired
    ReportsRepository reportsRepository;

    @GetMapping
    public String getReports(Model model){
        List<ReportISS> issReports = reportsRepository.findAll();
        model.addAttribute("iss_reports", issReports);
        return "reports-position";
    }
}
