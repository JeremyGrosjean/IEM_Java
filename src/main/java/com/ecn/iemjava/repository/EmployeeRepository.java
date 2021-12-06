package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.IntermissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    @Query("SELECT e FROM Employee e JOIN Form f on e = f.employee WHERE f.formStatus.id = 1")
    List<Employee> getEmployeeByCompletedForm();

    @Query("SELECT e FROM Employee e JOIN Form f on e = f.employee WHERE f.formStatus.id = 2")
    List<Employee> getEmployeeByEmptyForm();

    @Query("SELECT e FROM Employee e JOIN Intermission i ON e = i.employee ORDER BY i.startDate ASC")
    List<Employee> getEmployeeByIntermissionStartDateAsc();

    @Query("SELECT e FROM Employee e JOIN Intermission i ON e = i.employee ORDER BY i.startDate DESC")
    List<Employee> getEmployeeByIntermissionStartDateDesc();

//    @Query("SELECT e FROM Employee e JOIN Intermission i ON e = i.employee WHERE i.intermissionStatus.id = 2")
//    List<Employee> getEmployeeWithIntermissionOnGoing();
}
