package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Integer> {
}
