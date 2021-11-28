package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.FormStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormStatusRepository extends JpaRepository<FormStatus,Integer> {

    @Query("SELECT fs.formStatus FROM FormStatus fs WHERE fs = ?1")
    boolean getFormStatusById(FormStatus formStatus);
}
