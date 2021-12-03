package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.AccessRepository;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/access")
public class AccessController extends HttpServlet {
    AccessRepository accessRepository;

    public AccessController(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @PostMapping("/login")
    public User login(@RequestBody Access access, HttpServletRequest request) {
        try {
            Access loginInfos = this.accessRepository.findByAccount(access.getAccount());
            if (loginInfos.getPassword().equals(access.getPassword())) {
                return loginInfos.getUser();
            }
            else {
                return null ;
            }
        } catch (Exception e){
            return null ;
        }
    }

    @GetMapping("current-user")
    public User getCurrentUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute("user");
    }

    @GetMapping("/all")
    public List<Access> getAllAccess(){
        return this.accessRepository.findAll();
    }
}
