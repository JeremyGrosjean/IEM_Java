package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
