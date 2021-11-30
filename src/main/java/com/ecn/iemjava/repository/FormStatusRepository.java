package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.FormStatus;
import com.ecn.iemjava.models.IntermissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormStatusRepository extends JpaRepository<FormStatus,Integer> {

    @Query("select f from FormStatus f where f.formStatus = ?1")
    FormStatus getFormStatusByStatus(boolean status);
}
