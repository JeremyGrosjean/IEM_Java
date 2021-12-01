package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.AccessRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/access")
public class AccessController extends HttpServlet {
    AccessRepository accessRepository;

    public AccessController(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody Access access, HttpServletRequest request) {
        try {
            Access loginInfos = this.accessRepository.findByAccount(access.getAccount());
            if (loginInfos.getPassword().equals(access.getPassword())) {
                request.getSession().setAttribute("user", loginInfos.getUser());
                request.getSession().setAttribute("LoginMessage", "LoginOk");
            }
            else {
                request.getSession().setAttribute("LoginMessage", "Mot de passe erroné");
            }
        } catch (Exception e){
            request.getSession().setAttribute("LoginMessage", "Cet utilisateur n'existe pas");
        }
        return (String)request.getSession().getAttribute("LoginMessage");
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
