package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.Form;
import com.ecn.iemjava.models.FormStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form,String> {

    @Query("SELECT f.formStatus FROM Form f WHERE f.employee = ?1")
    FormStatus getFormStatusByEmployee(Employee employee);

    @Query("SELECT f FROM Form f WHERE f.employee.id = ?1")
    Form getFormByEmployee(String idEmployee);

    @Query("SELECT f FROM Form f WHERE f.formStatus.id = 1")
    List<Form> getCompletedForms();


}
