package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.AccessRepository;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.util.List;
import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.Admin;
import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/access")
public class AccessController {

    // Injection of Repository
    private EmployeeRepository employeeRepository;
    private AccessRepository accessRepository;
    private AdminRepository adminRepository;


    public AccessController(AccessRepository accessRepository,EmployeeRepository employeeRepository,AdminRepository adminRepository) {
        this.employeeRepository = employeeRepository;
        this.accessRepository = accessRepository;
        this.adminRepository= adminRepository;
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

    @GetMapping("/all")
    public List<Access> getAllAccess(){
        return this.accessRepository.findAll();
    }

    @GetMapping("/{id}")
    public  Access getById(@PathVariable("id") String id){
        Optional<Access> access=accessRepository.findById(id);
        return access.orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public Access deleteById(@PathVariable("id") String idaccess){

        List<Access> accesses=accessRepository.findAll();
        for(Access accessBDD:accesses){
            if(accessBDD.getId().equals(idaccess)){
                accessRepository.deleteById(idaccess);
                return  accessBDD;
            }
        }
        return null;
    }

    /**Avec id et access incomplet **/
    @PostMapping("/register/{id}")
    public Access addAccessByIdUser(@RequestBody Access access, @PathVariable("id") String iduser){
        String userstatus = "";
        Employee employeeRemider = new Employee();
        Admin adminRemider = new Admin();

        /** protection si l'user à deja un access**/
        // Récupère tous les id
        List<Access> accesses=accessRepository.findAll();
        // pour chaque accès
        for(Access accessBDD:accesses){
            //si l'utilisateur a déjà un access...
            if(accessBDD.getUser().getId().equals(iduser)){
                //...ne l'ajoute pas
                return  null;
            }

        }
        /** verify si l'id donnée est celui d'un admin**/
        // Récupère la liste des admins
        List<Admin> admins=adminRepository.findAll();
        // pour chaque admin
        for(Admin admin:admins){
            // si l'user est un admin
            if(admin.getId().equals(iduser)){
                userstatus="admin";
                adminRemider=admin;
            }
        }

        /** verify si l'id donnée est celui d'un employee**/
        List<Employee> employees=employeeRepository.findAll();
        for(Employee employee:employees){
            if(employee.getId().equals(iduser)){
                userstatus="employee";
                employeeRemider=employee;
            }
        }

        /** memorise les donnée en base**/
        switch (userstatus){
            case "employee":
                access.setUser(employeeRemider);
                accessRepository.save(access);
                break;
            case "admin":
                access.setUser(adminRemider);
                accessRepository.save(access);
                break;
            default:
                return null;
        }

        /** renvois l'access validé sinon les verification precedente on deja envoyer null**/
        return access;
    }



//    /**Avec access complet **/
//    @PostMapping("/register")
//    public Access addAccess(@RequestBody Access access){
//        String userstaus=new String();
//        Employee employeeRemider=new Employee();
//        Admin adminRemider=new Admin();
//
//        /** protection si l'user à deja un access**/
//        List<Access> accesses=accessRepository.findAll();
//        for(Access accessBDD:accesses){
//            if(accessBDD.getUser().getId().equals(access.getUser().getId())){
//
//                return  null;
//            }
//
//        }
//        /** verify si l'id donnée est celui d'un admin**/
//        List<Admin> admins=adminRepository.findAll();
//        for(Admin admin:admins){
//            if(access.getUser().getId().equals(admin.getId())){
//                userstaus="admin";
//                adminRemider=admin;
//            }
//
//        }
//
//        /** verify si l'id donnée est celui d'un employee**/
//        List<Employee> employees=employeeRepository.findAll();
//        for(Employee employee:employees){
//            if(access.getUser().getId().equals(employee.getId())){
//                userstaus="employee";
//                employeeRemider=employee;
//            }
//        }
//
//        /** memorise les donnée en base**/
//        switch (userstaus){
//            case "employee":
//                access.setUser(employeeRemider);
//                accessRepository.save(access);
//                break;
//            case "admin":
//                access.setUser(adminRemider);
//                accessRepository.save(access);
//                break;
//            default:
//                return null;
//        }
//
//        /** renvois l'access validé sinon les verification precedente on deja envoyer null**/
//        return access;
//    }

}
