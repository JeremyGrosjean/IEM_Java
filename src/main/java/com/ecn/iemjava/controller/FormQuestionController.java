package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.FormQuestion;
import com.ecn.iemjava.models.Question;
import com.ecn.iemjava.repository.FormQuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/form-question")
public class FormQuestionController {

    private FormQuestionRepository formQuestionRepository;

    public FormQuestionController(FormQuestionRepository formQuestionRepository) {
        this.formQuestionRepository = formQuestionRepository;
    }

//    @PostMapping("/custom-question")
//    public FormQuestion createCustomFormQuestion(@RequestBody FormQuestion formQuestion){
//        formQuestionRepository.save(formQuestion);
//        return formQuestion;
//    }

    @GetMapping("/all")
    public List<FormQuestion> getAllFormQuestions(){
        return formQuestionRepository.findAll();
    }

    @GetMapping("/question-answer/{id}")
    public List<FormQuestion> getFormQuestionsByEmployee(@PathVariable("id") String id){
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

    @GetMapping("/by-employee/{idEmployee}")
    public List<Question> getQuestionsByEmployee(@PathVariable("idEmployee") String id){
        return formQuestionRepository.getQuestionsByEmployeeId(id);
    }
}
