package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.FormQuestion;
import com.ecn.iemjava.models.Question;
import com.ecn.iemjava.repository.QuestionRepository;
import com.ecn.iemjava.services.IemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/question")
public class QuestionController {

    // Injection of InjectionRepository
    private QuestionRepository questionRepository;
    private IemService iemService;


    public QuestionController(QuestionRepository questionRepository, IemService iemService) {
        this.questionRepository = questionRepository;
        this.iemService = iemService;
    }

    // Request to add a question
    // TODO: change type of return wether it is needed or not (Question or void)
    @PostMapping("/{idEmployee}")
    public Question addCustomQuestion(@RequestBody Question question, @PathVariable("idEmployee") String id){
        if (!question.isGeneric()){
        questionRepository.save(question);
        iemService.addCustomQuestion(question,id);}
        return question;
    }

    // Request to get all the questions of the db
    // TODO : personalize to target the user's specific questions (include user in path)
    @GetMapping("/all")
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    // Request to get specific question with its id
    // TODO: deal with an Exception instead of returning "null" if the question hasn't been found
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable("id") String id){
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion.orElse(null);
    }

    @DeleteMapping("/delete/{idEmployee}/{idQuestion}")
    public void deleteQuestionById(@PathVariable("idQuestion") String idQuestion, @PathVariable("idEmployee") String idEmployee){
        iemService.deleteQuestionById(idQuestion, idEmployee);
    }
}
