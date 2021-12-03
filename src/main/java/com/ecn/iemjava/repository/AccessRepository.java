package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Integer> {

    Access findByAccount(String account);

    @Query("SELECT a.user FROM Access a WHERE a.account =?1")
    User findUserByAccount(String account);

    Access findByUser(User user);
}
