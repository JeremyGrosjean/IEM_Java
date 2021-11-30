package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, String> {

    @Query("SELECT a FROM Access a WHERE a.account=?1 AND a.password=?2")
    Access findByAccessAccountPassword(String account, String password);
}
