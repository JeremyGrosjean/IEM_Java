package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Activity;
import com.ecn.iemjava.repository.ActivityRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activity")
public class ActivityController {
    ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
}