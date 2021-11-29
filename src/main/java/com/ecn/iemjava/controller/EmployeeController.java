package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.*;
import com.ecn.iemjava.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    // Injection of Repository
    private EmployeeRepository employeeRepository;
    private FormRepository formRepository;
    private FormController formController;
    private IntermissionStatusRepository intermissionStatusRepository;
    private IntermissionRepository intermissionRepository;
    private FormStatusRepository formStatusRepository;
    private FormQuestionRepository formQuestionRepository;
    private QuestionRepository questionRepository;

    public EmployeeController(EmployeeRepository employeeRepository, FormRepository formRepository, FormController formController, IntermissionStatusRepository intermissionStatusRepository, IntermissionRepository intermissionRepository, FormStatusRepository formStatusRepository, FormQuestionRepository formQuestionRepository, QuestionRepository questionRepository) {
        this.employeeRepository = employeeRepository;
        this.formRepository = formRepository;
        this.formController = formController;
        this.intermissionStatusRepository = intermissionStatusRepository;
        this.intermissionRepository = intermissionRepository;
        this.formStatusRepository = formStatusRepository;
        this.formQuestionRepository = formQuestionRepository;
        this.questionRepository = questionRepository;
    }

    // Request to add an answer
    // TODO: change type of return wether it is needed or not (Employee or void)
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        Form form = new Form();
        FormStatus formStatus = new FormStatus();
        FormQuestion formQuestion = new FormQuestion();
        Question question = new Question();
        Intermission intermission = new Intermission();
        IntermissionStatus intermissionStatus = new IntermissionStatus();
        // Déclaration d'un form status a false
            formStatus.setFormStatus(false);
            // Déclaration d'un formQuestion à 1 question
            // TODO: remplacer par la methode formulaire standard
            formQuestion.setQuestion(question);
            question.setContent("Nouvelle question pour voir si ca marche");
            question.setForm(form);
            question.setFormQuestion(formQuestion);

        // Déclaration d'un formulaire
        form.setEmployee(employee);
        form.setFormStatus(formStatus);
        form.setFormQuestion(formQuestion);

        formQuestion.setForm(form);

        intermission.setEmployee(employee);
        intermission.setStartDate(null);
        intermission.setIntermissionStatus(intermissionStatus);

        // Persiter en base l'employee, puis le formulaire, puis le formulaire
        employeeRepository.save(employee);
        questionRepository.save(question);
        formQuestionRepository.save(formQuestion);
        formStatusRepository.save(formStatus);
        formController.addForm(form);
        intermissionStatusRepository.save(intermissionStatus);
        intermissionRepository.save(intermission);

        return employee;
    }

    // Request to get all the questions of the db
    // TODO : personalize to target the specific employee (include intermission? in path)
    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Request to get specific question with its id
    // TODO: deal with an Exception instead of returning "null" if the employee hasn't been found
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @GetMapping("/formstatus/{id}")
    public boolean getFormStatus(@PathVariable("id") String id){
        Employee employee = getEmployeeById(id);
        FormStatus formStatus = formRepository.getFormStatusByEmployee(employee);
        return formStatus.isFormStatus();
    }

}
