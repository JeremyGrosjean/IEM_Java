package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.*;
import com.ecn.iemjava.repository.*;
import com.ecn.iemjava.services.IemService;
import com.ecn.iemjava.services.SendMailService;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    // Injection of Repositories
    private EmployeeRepository employeeRepository;
    private FormRepository formRepository;
    private IntermissionRepository intermissionRepository;
    private IemService iemService;
    private SendMailService sendMailService;

    public EmployeeController(EmployeeRepository employeeRepository, FormRepository formRepository, IntermissionRepository intermissionRepository, IemService iemService, SendMailService sendMailService) {
        this.employeeRepository = employeeRepository;
        this.formRepository = formRepository;
        this.intermissionRepository = intermissionRepository;
        this.iemService = iemService;
        this.sendMailService = sendMailService;
    }

    // Request to add an answer
    // TODO: change type of return wether it is needed or not (Employee or void)
    @PostMapping("/{startDate}")
    public Employee addEmployee(@RequestBody Employee employee, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) throws MailjetSocketTimeoutException, MailjetException {
        // Declaration of a new Form, FormQuestion and Intermission to be associated to the employee
        Form form = iemService.createForm(employee);
        iemService.createFormQuestions(form);
        iemService.createIntermission(employee, startDate);

        employeeRepository.save(employee);
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

    // TODO : il faut completer le profil en intérgralité sinon champ vides
    @PutMapping("/edit/{startDate}-{endDate}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate ){
        if (!employee.getId().isEmpty()){
            Intermission intermission = intermissionRepository.getIntermissionByEmployee(employee);
            intermission.setStartDate(startDate);
            intermission.setEndDate(endDate);

            employeeRepository.save(employee);
            intermissionRepository.save(intermission);
        }
        return employee;
    }

    @GetMapping("/send-mail/{idEmployee}")
    public void sendMail(@PathVariable("idEmployee") String id) throws MailjetSocketTimeoutException, MailjetException {
        Employee employee = getEmployeeById(id);
        Intermission intermission = intermissionRepository.getIntermissionByEmployeeId(id);
        sendMailService.sendMail(employee, intermission);
    }
}
