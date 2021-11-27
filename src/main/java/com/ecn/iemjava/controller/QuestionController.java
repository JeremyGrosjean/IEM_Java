package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Question;
import com.ecn.iemjava.repository.QuestionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    QuestionRepository questionRepository;



//    @PostMapping
//    public Question addQuestion(@RequestBody Question question){
//
//    }
}
