package com.bobrowski.IssTrackingApp.web.controllers;

import com.bobrowski.IssTrackingApp.biz.model.IssPosition;
import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.service.PositionReportsService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/reports-position")
public class ReportsController {
    private final PositionReportsService positionReportsService;
    private final Gson gson = new Gson();

    @GetMapping
    public String getReports(Model model){
        List<IssPositionReport> issReports = positionReportsService.findAll();
        Collections.reverse(issReports);
        issReports = issReports.stream().limit(200).collect(Collectors.toList());
        List<IssPosition> positions = issReports.stream().map(IssPositionReport::getIssPosition).collect(Collectors.toList());
        model.addAttribute("positions", gson.toJson(positions));
        model.addAttribute("iss_reports", issReports);
        return "reports-position";
    }
}
