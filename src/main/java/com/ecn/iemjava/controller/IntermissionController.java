package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.Intermission;
import com.ecn.iemjava.repository.EmployeeRepository;
import com.ecn.iemjava.repository.IntermissionRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/intermission")
public class IntermissionController {

    private IntermissionRepository intermissionRepository;
    private EmployeeRepository employeeRepository;


    public IntermissionController(IntermissionRepository intermissionRepository, EmployeeRepository employeeRepository) {
        this.intermissionRepository = intermissionRepository;
        this.employeeRepository = employeeRepository;
    }


    @PostMapping
    public Intermission addIntermission(@RequestBody Intermission intermission) {
        intermissionRepository.save(intermission);
        return intermission;
    }

    @GetMapping("/all")
    public List<Intermission> getAllIntermission(){
        return intermissionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Intermission getIntermissionById(@PathVariable("id") Integer id){
        Optional<Intermission> optionalIntermission = intermissionRepository.findById(id);
        return optionalIntermission.orElse(null);
    }

    @GetMapping("/start-date/{id}")
    public LocalDate getIntermissionStartDateByEmployeeId(@PathVariable("id") String id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.orElse(null);
        Intermission intermission = intermissionRepository.getIntermissionByEmployee(employee);
        return intermission.getStartDate();
    }


//    @PutMapping("/startdate/{id}/{startDate}")
//    public LocalDate setStartDateByEmployeeId(@PathVariable("id") String id, @PathVariable("startDate") LocalDate startDate){
//        Employee employee = employeeController.getEmployeeById(id);
//        Intermission intermission = intermissionRepository.getIntermissionByEmployee(employee);
//        intermission.setStartDate(startDate);
//        intermissionRepository.save(intermission);
//        return intermission.getStartDate();
//    }
}
