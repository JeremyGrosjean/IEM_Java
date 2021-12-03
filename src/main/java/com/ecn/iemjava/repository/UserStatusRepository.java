package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.User;
import com.ecn.iemjava.models.UserStatus;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus,Integer> {

    Optional<UserStatus> findByName(UserStatus name);
}
