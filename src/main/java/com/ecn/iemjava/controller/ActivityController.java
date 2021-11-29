package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Activity;
import com.ecn.iemjava.repository.ActivityRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.function.BiConsumer;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activity")
public class ActivityController {
    ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/all")
    public Map<Date,List<Activity>> getAllActivities() {
        return sortActivities(activityRepository.findAll());
    }

    @ResponseBody
    @GetMapping("/week/{dateBeginning}/{dateEnding}")
    public Map<Date,List<Activity>> getCustomedActivities(@PathVariable ("dateBeginning") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateBeginning,
                                           @PathVariable ("dateEnding") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateEnding) {
        return sortActivities(activityRepository.findActivityByCurrentWeek(dateBeginning, dateEnding));
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity, HttpSession session){
        activityRepository.save(activity);
        return activity;
    }

    public Map<Date, List<Activity>> sortActivities(List <Activity> activities){
        Map<Date, List<Activity>> sortedActivities = new HashMap<>();
        List<Activity> activitiesByDay = new ArrayList<>();
        activities.forEach(activity -> {
            if (!sortedActivities.containsKey(activity.getDate())){
                activitiesByDay.add(activity);
                sortedActivities.put(activity.getDate(), activitiesByDay);
                activitiesByDay.clear();
            }
            else{
                sortedActivities.get(activity.getDate()).add(activity);
            }
        });
        return sortedActivities;
    }
}