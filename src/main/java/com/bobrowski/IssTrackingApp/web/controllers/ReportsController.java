package com.bobrowski.IssTrackingApp.web.controllers;

import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.repositories.IssPositionReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/reports-position")
public class ReportsController {
    private final IssPositionReportsRepository reportsRepository;

    @GetMapping
    public String getReports(Model model){
        List<IssPositionReport> issReports = reportsRepository.findAll();
        model.addAttribute("iss_reports", issReports);
        return "reports-position";
    }
}
