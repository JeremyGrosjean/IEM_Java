package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.repository.AccessRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/access")
public class AccessController {
    public AccessController(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }
    private AccessRepository accessRepository;

    @GetMapping
    public List<Access> getAll(){
        List<Access> accesses=accessRepository.findAll();

        return accesses;
    }

    @GetMapping("/{id}")
    public  Optional<Access> getById(@PathVariable("id") Integer id){
        Optional<Access> access=accessRepository.findById(id);

        return access;
    }

    @PostMapping("/postaccess")
    public Access postAccess(@RequestBody Access access){

        return accessRepository.save(access);
    }


//    @PostMapping("/={login}&={mdp}")
//    public  String logON(@PathVariable("login") String login,@PathVariable("mdp")String mdp){
//
//    return null;
//    }

}
