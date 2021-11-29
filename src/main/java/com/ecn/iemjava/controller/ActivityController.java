package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Activity;
import com.ecn.iemjava.repository.ActivityRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activity")
public class ActivityController {
    ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/all")
    public Map<LocalDate,List<Activity>> getAllActivities() {
        return sortActivities(activityRepository.findAll());
    }

    @ResponseBody
    @GetMapping("/week/{dateBeginning}/{dateEnding}")
    public Map<LocalDate,List<Activity>> getCustomedActivities(@PathVariable ("dateBeginning") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBeginning,
                                           @PathVariable ("dateEnding") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnding) {
        return sortActivities(activityRepository.findActivityByCurrentWeek(dateBeginning, dateEnding));
    }

    @ResponseBody
    @GetMapping("/oneDay/{date}")
    public Map<LocalDate,List<Activity>> getCustomedActivities(@PathVariable ("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date){
        return sortActivities(activityRepository.findActivityByOneDay(date));
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity, HttpSession session){
        activityRepository.save(activity);
        return activity;
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable ("id") Integer id){
        activityRepository.deleteById(id);
    }

    //TODO : just one day



    public Map<LocalDate, List<Activity>> sortActivities(List <Activity> activities){
        Map<LocalDate, List<Activity>> sortedActivities = new HashMap<>();
        activities.forEach(activity -> {
            if (!sortedActivities.containsKey(activity.getDate())){
                List<Activity> activitiesByDay = new ArrayList<>();
                activitiesByDay.add(activity);
                sortedActivities.put(activity.getDate(), activitiesByDay);
            }
            else{
                List<Activity> activitiesByDay = sortedActivities.get(activity.getDate());
                activitiesByDay.add(activity);
                sortedActivities.put(activity.getDate(), activitiesByDay);
            }
        });
        return sortedActivities;
    }
}