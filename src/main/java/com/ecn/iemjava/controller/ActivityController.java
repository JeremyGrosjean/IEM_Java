package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Activity;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.ActivityRepository;
import com.ecn.iemjava.repository.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activity")
public class ActivityController {
    ActivityRepository activityRepository;
    UserRepository userRepository;

    public ActivityController(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all/user/{id}")
    public Map<LocalDate,List<Activity>> getAllByUser(@PathVariable ("id") String id) {
        User user = userRepository.findById(id).orElse(null);
        return sortActivities(activityRepository.findAllByEmployee(user));
    }

    @GetMapping("/all/user/{id}/test")
    public List<Activity> getAllByUserTest(@PathVariable ("id") String id) {
        User user = userRepository.findById(id).orElse(null);
        return activityRepository.findAllByEmployee(user);
    }

    @ResponseBody
    @GetMapping("/week/{dateBeginning}/{dateEnding}/{idUser}")
    public Map<LocalDate,List<Activity>> getCustomedActivities(@PathVariable ("dateBeginning") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBeginning,
                                           @PathVariable ("dateEnding") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnding,
                                           @PathVariable ("idUser") String idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        return sortActivities(activityRepository.findActivityByCurrentWeekByUser(dateBeginning, dateEnding, user));
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
    public void deleteActivity(@PathVariable ("id") String id){
        activityRepository.deleteById(id);
    }


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