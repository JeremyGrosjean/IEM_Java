package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.Admin;
import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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


    @GetMapping
    public List<Access> getAll(){
        List<Access> accesses=accessRepository.findAll();

        return accesses;
    }

    @GetMapping("/{id}")
    public  Access getById(@PathVariable("id") String id){
        Optional<Access> access=accessRepository.findById(id);

        return access.orElse(null);
    }

    @PostMapping("/delecte/{id}")
    public Access dellcteById(@PathVariable("id") String idaccess){

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
    public Access addAccessByIdUser(@RequestBody Access access,@PathVariable("id") String iduser){
        String userstaus=new String();
        Employee employeeRemider=new Employee();
        Admin adminRemider=new Admin();

        /** protection si l'user à deja un access**/
        List<Access> accesses=accessRepository.findAll();
        for(Access accessBDD:accesses){
            if(accessBDD.getUser().getId().equals(iduser)){

                return  null;
            }

        }
        /** verify si l'id donnée est celui d'un admin**/
        List<Admin> admins=adminRepository.findAll();
        for(Admin admin:admins){
            if(admin.getId().equals(iduser)){
                userstaus="admin";
                adminRemider=admin;
            }

        }

        /** verify si l'id donnée est celui d'un employee**/
        List<Employee> employees=employeeRepository.findAll();
        for(Employee employee:employees){
            if(employee.getId().equals(iduser)){
                userstaus="employee";
                employeeRemider=employee;
            }
        }

        /** memorise les donnée en base**/
        switch (userstaus){
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



    /**Avec access complet **/
    @PostMapping("/register")
    public Access addAccess(@RequestBody Access access){
        String userstaus=new String();
        Employee employeeRemider=new Employee();
        Admin adminRemider=new Admin();

        /** protection si l'user à deja un access**/
        List<Access> accesses=accessRepository.findAll();
        for(Access accessBDD:accesses){
            if(accessBDD.getUser().getId().equals(access.getUser().getId())){

                return  null;
            }

        }
        /** verify si l'id donnée est celui d'un admin**/
        List<Admin> admins=adminRepository.findAll();
        for(Admin admin:admins){
            if(access.getUser().getId().equals(admin.getId())){
                userstaus="admin";
                adminRemider=admin;
            }

        }

        /** verify si l'id donnée est celui d'un employee**/
        List<Employee> employees=employeeRepository.findAll();
        for(Employee employee:employees){
            if(access.getUser().getId().equals(employee.getId())){
                userstaus="employee";
                employeeRemider=employee;
            }
        }

        /** memorise les donnée en base**/
        switch (userstaus){
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


}
