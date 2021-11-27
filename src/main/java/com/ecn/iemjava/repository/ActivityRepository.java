package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query("select a from Activity a where (a.date > ?1) and (a.date < ?2)")
    List<Activity> findActivityByCurrentWeek(Date dateBeginning, Date dateEnding);
}
