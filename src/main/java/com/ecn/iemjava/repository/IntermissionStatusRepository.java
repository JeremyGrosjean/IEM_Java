package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.IntermissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermissionStatusRepository extends JpaRepository<IntermissionStatus,String> {

    @Query("select i from IntermissionStatus i where i.status = ?1")
    IntermissionStatus getIntermissionStatusByStatus(boolean status);
}
