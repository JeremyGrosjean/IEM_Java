package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.Intermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermissionRepository extends JpaRepository<Intermission,Integer> {

    @Query("SELECT i FROM Intermission i WHERE i.employee = ?1")
    Intermission getIntermissionByEmployee(Employee employee);
}
