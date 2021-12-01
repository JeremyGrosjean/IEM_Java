package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.*;
import com.ecn.iemjava.repository.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    // Injection of Repository
    private EmployeeRepository employeeRepository;
    private FormController formController;
    private FormRepository formRepository;
    private FormQuestionController formQuestionController;
    private IntermissionController intermissionController;
    private IntermissionStatusRepository intermissionStatusRepository;
    private FormStatusRepository formStatusRepository;

    public EmployeeController(EmployeeRepository employeeRepository, FormController formController, FormRepository formRepository, FormQuestionController formQuestionController, IntermissionController intermissionController, IntermissionStatusRepository intermissionStatusRepository, FormStatusRepository formStatusRepository) {
        this.employeeRepository = employeeRepository;
        this.formController = formController;
        this.formRepository = formRepository;
        this.formQuestionController = formQuestionController;
        this.intermissionController = intermissionController;
        this.intermissionStatusRepository = intermissionStatusRepository;
        this.formStatusRepository = formStatusRepository;
    }

    // Request to add an answer
    // TODO: change type of return wether it is needed or not (Employee or void)
    @PostMapping("/{startDate}")
    public Employee addEmployee(@RequestBody Employee employee, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        // Declaration of a new Form, FormQuestion and Intermission to be associated to the employee
        Form form = new Form();
        FormQuestion formQuestion = new FormQuestion();
        Intermission intermission = new Intermission();
        // Link the formQuestion
        formQuestion.setForm(form);
        formQuestion.setQuestion(null);

        form.setEmployee(employee);
        form.setFormStatus(formStatusRepository.getFormStatusByStatus(false));

        intermission.setEmployee(employee);
        intermission.setStartDate(startDate);
        intermission.setEndDate(null);
        intermission.setIntermissionStatus(intermissionStatusRepository.getIntermissionStatusByStatus(false));

        employeeRepository.save(employee);
        formController.addForm(form);
        formQuestionController.addFormQuestion(formQuestion);
        intermissionController.addIntermission(intermission);

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

    // Request to get the form status
    @GetMapping("/formstatus/{id}")
    public boolean getFormStatus(@PathVariable("id") String id){
        Employee employee = getEmployeeById(id);
        FormStatus formStatus = formRepository.getFormStatusByEmployee(employee);
        return formStatus.isFormStatus();
    }

    @GetMapping("/employees-with/forms-completed")
    public List<Employee> getEmployeeByCompletedForms(){
        return employeeRepository.getEmployeeByCompletedForm();
    }

    @GetMapping("/employees-with/forms-empty")
    public List<Employee> getEmployeeByEmptyForms(){
        return employeeRepository.getEmployeeByEmptyForm();
    }

    @GetMapping("/employees-with/date-asc")
    public List<Employee> getEmployeeByIntermissionStartDateAsc(){
        return employeeRepository.getEmployeeByIntermissionStartDateAsc();
    }

    @GetMapping("/employees-with/date-desc")
    public List<Employee> getEmployeeByIntermissionStartDateDesc(){
        return employeeRepository.getEmployeeByIntermissionStartDateDesc();
    }

}
