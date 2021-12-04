package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.FormQuestion;
import com.ecn.iemjava.models.Question;
import com.ecn.iemjava.repository.FormQuestionRepository;
import com.ecn.iemjava.repository.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    // Injection of InjectionRepository
    private QuestionRepository questionRepository;
    private FormQuestionRepository formQuestionRepository;
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Request to add a question
    // TODO: change type of return wether it is needed or not (Question or void)
    @PostMapping()
    public Question addCustomQuestion(@RequestBody Question question){
        questionRepository.save(question);
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
}
