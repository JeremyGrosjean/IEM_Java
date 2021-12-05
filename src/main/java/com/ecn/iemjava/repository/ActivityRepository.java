package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Activity;
import com.ecn.iemjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
    @Query("select a from Activity a where (a.date >= ?1) and (a.date <= ?2) and (a.employee = ?3)")
    List<Activity> findActivityByCurrentWeekByUser(LocalDate dateBeginning, LocalDate dateEnding, User user);

    @Query("select a from Activity a where a.date = :date")
    List<Activity> findActivityByOneDay(LocalDate date);

    List<Activity> findAllByEmployee(User user);

//    List<Activity> findAllByUser(String id);
}
