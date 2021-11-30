package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.Intermission;
import com.ecn.iemjava.repository.IntermissionRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intermission")
public class IntermissionController {

    private IntermissionRepository intermissionRepository;
    private EmployeeController employeeController;

    public IntermissionController(IntermissionRepository intermissionRepository, EmployeeController employeeController) {
        this.intermissionRepository = intermissionRepository;
        this.employeeController = employeeController;
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

    @PutMapping("/startdate/{id}/{startDate}")
    public LocalDate setStartDateByEmployeeId(@PathVariable("id") String id, @PathVariable("startDate") LocalDate startDate){
        Employee employee = employeeController.getEmployeeById(id);
        Intermission intermission = intermissionRepository.getIntermissionByEmployee(employee);
        intermission.setStartDate(startDate);
        intermissionRepository.save(intermission);
        return intermission.getStartDate();
    }
}
