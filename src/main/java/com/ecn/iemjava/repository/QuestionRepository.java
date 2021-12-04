package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query("SELECT q FROM Question q WHERE q.generic = true")
    List<Question> getGenericQuestions();
}
