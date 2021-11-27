package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Admin;
import com.ecn.iemjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<User,Integer> {
}