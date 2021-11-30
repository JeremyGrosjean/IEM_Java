package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus,Integer> {
}
