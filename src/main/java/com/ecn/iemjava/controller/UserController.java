package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @GetMapping("/status-of/{id}")
    public String getStatusOfOneEmployee(@PathVariable("id") String id){
        User user = getUserById(id);
        return user.getStatus();
    }
}
