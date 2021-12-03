package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.repository.AccessRepository;
import com.ecn.iemjava.repository.EmployeeRepository;
import com.ecn.iemjava.repository.FormRepository;
import com.ecn.iemjava.repository.IntermissionStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/access")
public class AccessController {

    // Injection of Repository
    private EmployeeRepository employeeRepository;
    private AccessRepository accessRepository;


    public AccessController(AccessRepository accessRepository,EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.accessRepository = accessRepository;
    }


    @GetMapping
    public List<Access> getAll(){
        List<Access> accesses=accessRepository.findAll();

        return accesses;
    }

    @GetMapping("/{id}")
    public  Optional<Access> getById(@PathVariable("id") String id){
        Optional<Access> access=accessRepository.findById(id);

        return access;
    }

    @PostMapping("/register/{idUser}")
    public Access postAccess(@RequestBody Access access, @PathVariable("idUser") String idUser){
//        System.out.println(access.getUser().getId());
//        Optional<Employee> optionalEmployee = employeeRepository.findById(access.getUser().getId());
//        System.out.println(optionalEmployee.toString());
////        if(access.getUser().getId()==optionalEmployee.stream().filter()){
////
////        }
//        accessRepository.save(access);
        AccesidUser  access1 = new Access();
        access1 = access;
        return access1;
    }


//    @PostMapping("/={login}&={mdp}")
//    public  String logON(@PathVariable("login") String login,@PathVariable("mdp")String mdp){
//
//    return null;
//    }

}
