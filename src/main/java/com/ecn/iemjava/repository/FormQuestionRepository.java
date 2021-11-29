package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.FormQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormQuestionRepository extends JpaRepository<FormQuestion, Integer> {
}
