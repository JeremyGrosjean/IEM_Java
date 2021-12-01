package com.ecn.iemjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/helloworld")
    public class test {
        @GetMapping // cette méthode répondra aux requêtes HTTP GET
        public String helloWorld() {
            return "Hello World !";    }
}
