package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
    @Query("select a from Activity a where (a.date >= ?1) and (a.date <= ?2)")
    List<Activity> findActivityByCurrentWeek(LocalDate dateBeginning, LocalDate dateEnding);

    @Query("select a from Activity a where a.date = :date")
    List<Activity> findActivityByOneDay(LocalDate date);

//    List<Activity> findAllByUser(String id);
}
