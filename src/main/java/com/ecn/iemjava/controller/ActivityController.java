package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Activity;
import com.ecn.iemjava.repository.ActivityRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @ResponseBody
    @GetMapping("/week/{dateBeginning}/{dateEnding}")
    public List<Activity> getCustomedActivities(@PathVariable ("dateBeginning") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateBeginning,
                                           @PathVariable ("dateEnding") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateEnding) {
        return activityRepository.findActivityByCurrentWeek(dateBeginning, dateEnding);
    }

//    @GetMapping("/{id}")
//    public Article getArticleById(@PathVariable("id") Integer idArticle){
//        Optional<Article> optional = articleRepository.fin  dById(idArticle);
//        return optional.orElse(null);
//    }
}