package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Form;
import com.ecn.iemjava.models.FormQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface FormQuestionRepository extends JpaRepository<FormQuestion, String> {


}
