package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Form;
import com.ecn.iemjava.models.FormQuestion;
import com.ecn.iemjava.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface FormQuestionRepository extends JpaRepository<FormQuestion, String> {

    @Query("SELECT f.question FROM FormQuestion f WHERE f.form.employee.id = ?1")
    List<Question> getQuestionsByEmployeeId(String id);

    @Query("SELECT f FROM FormQuestion f WHERE f.form.employee.id = ?1")
    List<FormQuestion> getFormQuestionsByEmployeeId(String id);
}
