package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Employee;
import com.ecn.iemjava.models.Form;
import com.ecn.iemjava.repository.FormRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/form")
public class FormController {

    // Injection of Repository
    private FormRepository formRepository;
    public FormController(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    // Request to add an answer
    // TODO: change type of return whether it is needed or not (Form or void)
    @PostMapping()
    public Form addForm(@RequestBody Form form, String idEmployee){
        formRepository.save(form);
        return form;
    }

    // Request to get all the questions of the db
    // TODO : personalize to target the user's specific forms (include form in path)
    @GetMapping("/all")
    public List<Form> getAllForms(){
        return formRepository.findAll();
    }

    // Request to get specific question with its id
    // TODO: deal with an Exception instead of returning "null" if the form hasn't been found
    @GetMapping("/{id}")
    public Form getFormById(@PathVariable("id") String id){
        Optional<Form> optionalForm = formRepository.findById(id);
        return optionalForm.orElse(null);
    }

    @GetMapping("/by-employee/{idEmployee}")
    public Form getFormByEmployee(@PathVariable("idEmployee") String id){
        return formRepository.getFormByEmployee(id);
    }



}
