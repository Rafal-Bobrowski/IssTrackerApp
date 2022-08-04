package com.bobrowski.IssTrackingApp.web.controllers;

import com.bobrowski.IssTrackingApp.biz.model.Astronaut;
import com.bobrowski.IssTrackingApp.service.PeopleInSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/people-in-space")
public class PeopleInSpaceController {
    private final PeopleInSpaceService peopleInSpaceService;

    @GetMapping
    public String getReports(Model model){
        List<Astronaut> astronauts = peopleInSpaceService.findAll();
        model.addAttribute("astronauts", astronauts);
        return "people-in-space";
    }
}
