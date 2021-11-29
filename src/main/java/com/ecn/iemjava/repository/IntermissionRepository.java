package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Intermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermissionRepository extends JpaRepository<Intermission,Integer> {
}
