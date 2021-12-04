package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Answer;
import com.ecn.iemjava.models.FormQuestion;
import com.ecn.iemjava.models.Question;
import com.ecn.iemjava.repository.FormQuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formquestion")
public class FormQuestionController {

    private FormQuestionRepository formQuestionRepository;

    public FormQuestionController(FormQuestionRepository formQuestionRepository) {
        this.formQuestionRepository = formQuestionRepository;
    }


    @PostMapping
    public FormQuestion addFormQuestion(@RequestBody FormQuestion formQuestion){
        formQuestionRepository.save(formQuestion);
        return formQuestion;
    }

    @GetMapping("/all")
    public List<FormQuestion> getAllFormQuestions(){
        return formQuestionRepository.findAll();
    }

    @GetMapping("/question-answer/{id}")
    public List<FormQuestion> getFormQuestion(@PathVariable("id") String id){
        List<FormQuestion> formQuestionList;
        formQuestionList = getAllFormQuestions();

        List<FormQuestion> formQuestionListByEmployee = new ArrayList<>();

        formQuestionList.forEach((formQuestion -> {
            if (formQuestion.getForm().getEmployee().getId().equals(id)){
                formQuestionListByEmployee.add(formQuestion);
            }
        }));
        return formQuestionListByEmployee;
    }
}
