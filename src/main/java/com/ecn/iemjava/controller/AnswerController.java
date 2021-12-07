package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Answer;
import com.ecn.iemjava.models.Form;
import com.ecn.iemjava.models.FormQuestion;
import com.ecn.iemjava.repository.AnswerRepository;
import com.ecn.iemjava.repository.FormRepository;
import com.ecn.iemjava.repository.FormStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/answer")
public class AnswerController {

    // Injection of Repository
    AnswerRepository answerRepository;
    FormStatusRepository formStatusRepository;

    public AnswerController(AnswerRepository answerRepository, FormStatusRepository formStatusRepository) {
        this.answerRepository = answerRepository;
        this.formStatusRepository = formStatusRepository;
    }

    // Request to add an answer
    // TODO: change type of return wether it is needed or not (Answer or void)
    @PostMapping
    public Answer addAnswer(@RequestBody Answer answer){
        answerRepository.save(answer);
        return answer;
    }

    // Request to get all the questions of the db
    // TODO : personalize to target the user's specific answers (include user in path)
    @GetMapping("/all")
    public List<Answer> getAllAnswers(){
        return answerRepository.findAll();
    }

    // Request to get specific question with its id
    // TODO: deal with an Exception instead of returning "null" if the answer hasn't been found
    @GetMapping("/{id}")
    public Answer getAnswerById(@PathVariable("id") String id){
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        return optionalAnswer.orElse(null);
    }

    @PutMapping("/persist")
    public void persistAnswers(@RequestBody List<FormQuestion> formQuestionList){
        formQuestionList.forEach((formQuestion -> {
            answerRepository.save(formQuestion.getAnswer());
            Form form = formQuestion.getForm();
            form.setFormStatus(formStatusRepository.getFormStatusByStatus(true));
        }));
    }
}
