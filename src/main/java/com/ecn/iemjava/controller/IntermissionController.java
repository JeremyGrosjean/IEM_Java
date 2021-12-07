package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.EndIntermission;
import com.ecn.iemjava.models.Intermission;
import com.ecn.iemjava.repository.EmployeeRepository;
import com.ecn.iemjava.repository.IntermissionRepository;
import com.ecn.iemjava.repository.IntermissionStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/intermission")
public class IntermissionController {

    private IntermissionRepository intermissionRepository;
    private IntermissionStatusRepository intermissionStatusRepository;
    private EmployeeRepository employeeRepository;


    public IntermissionController(IntermissionRepository intermissionRepository, IntermissionStatusRepository intermissionStatusRepository, EmployeeRepository employeeRepository) {
        this.intermissionRepository = intermissionRepository;
        this.intermissionStatusRepository = intermissionStatusRepository;
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

    @GetMapping("/by-employee/{idEmployee}")
    public Intermission getIntermissionByEmployee(@PathVariable("idEmployee") String id){
        return intermissionRepository.getIntermissionByEmployeeId(id);
    }

    @PutMapping("/end-intermission")
    public void setEndDateByEmployeeId(@RequestBody EndIntermission endIntermission){
        Intermission intermission = intermissionRepository.getIntermissionByEmployeeId(endIntermission.getIdEmployee());
        intermission.setEndDate(endIntermission.getEndDate());
        intermissionRepository.save(intermission);
        intermission.setIntermissionStatus(intermissionStatusRepository.getIntermissionStatusByStatus(true));
    }
}
