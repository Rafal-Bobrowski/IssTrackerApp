package com.bobrowski.IssTrackingApp.web.controllers;

import com.bobrowski.IssTrackingApp.biz.model.IssPosition;
import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.service.PositionReportsService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/reports-position")
public class ReportsController {
    private final PositionReportsService positionReportsService;
    private final Gson gson = new Gson();


    @ModelAttribute("positions")
    public String getPositions(){
        List<IssPosition> positions = positionReportsService.findPositionsFromNewestLimited(200);
        return gson.toJson(positions);
    }

    @ModelAttribute("iss_reports")
    public Page<IssPositionReport> getIssReports(Pageable page){
        return positionReportsService.findAll(page);
    }

    @GetMapping
    public String getReports(){
        return "reports-position";
    }
}
