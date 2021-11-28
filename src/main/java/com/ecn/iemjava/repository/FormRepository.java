package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.Form;
import com.ecn.iemjava.models.FormStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form,Integer> {

    @Query("SELECT f.formStatus FROM Form f WHERE f.employee = ?1")
    FormStatus getFormStatusByEmployee(Employee employee);
}
