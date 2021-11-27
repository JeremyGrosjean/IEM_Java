package com.ecn.iemjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @GetMapping // cette méthode répondra aux requêtes HTTP GET
    public String helloWorld() {
        return "Hello World !";    }
}