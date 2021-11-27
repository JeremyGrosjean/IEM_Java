package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // Injection of Repository
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Request to add an answer
    // TODO: change type of return wether it is needed or not (Employee or void)
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
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
    public Employee getEmployeeById(@PathVariable("id") Integer id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

}
