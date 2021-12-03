package com.ecn.iemjava.services;

import com.ecn.iemjava.models.*;
import com.ecn.iemjava.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IemService {

    private FormStatusRepository formStatusRepository;
    private FormRepository formRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private FormQuestionRepository formQuestionRepository;
    private IntermissionRepository intermissionRepository;
    private IntermissionStatusRepository intermissionStatusRepository;

    public IemService(FormStatusRepository formStatusRepository, FormRepository formRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, FormQuestionRepository formQuestionRepository) {
        this.formStatusRepository = formStatusRepository;
        this.formRepository = formRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.formQuestionRepository = formQuestionRepository;
    }

    public Form createForm(Employee employee){
        Form form = new Form();
        form.setEmployee(employee);
        form.setFormStatus(formStatusRepository.getFormStatusByStatus(false));
        formRepository.save(form);
        return form;
    }


    public List<FormQuestion> createFormQuestions(Form form){
        // Get list of Generic Questions
        List<Question> genericQuestions = questionRepository.getGenericQuestions();
        // New list of FormQuestion
        List<FormQuestion> formQuestionList = new ArrayList<>();
        // For each question of the Generic Question List, we :
        genericQuestions.forEach( (question -> {
            // New FormQuestion linked to the Form
            FormQuestion formQuestion = new FormQuestion();
            formQuestion.setForm(form);
            // New Question, linked to the FormQuestion, set content (same as the generic one) and set generic od new Question to false
            Question newQuestion = new Question();
            newQuestion.setContent(question.getContent());
            newQuestion.setGeneric(false);
            questionRepository.save(newQuestion);
            formQuestion.setQuestion(question);
            // New Answer, linked to FormQuestion, answer empty for now
            Answer answer = new Answer();
            answerRepository.save(answer);
            formQuestion.setAnswer(answer);
            formQuestionRepository.save(formQuestion);
            formQuestionList.add(formQuestion);
        }));
        return formQuestionList;
    }

    public Intermission createIntermission(Employee employee, LocalDate startDate){
        Intermission intermission = new Intermission();
        intermission.setEmployee(employee);
        intermission.setStartDate(startDate);
        intermission.setEndDate(null);
        intermission.setIntermissionStatus(intermissionStatusRepository.getIntermissionStatusByStatus(false));
        intermissionRepository.save(intermission);
        return intermission;
    }


}
