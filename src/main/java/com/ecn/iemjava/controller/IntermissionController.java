package com.ecn.iemjava.controller;

import com.ecn.iemjava.models.Intermission;
import com.ecn.iemjava.repository.IntermissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intermission")
public class IntermissionController {

    private IntermissionRepository intermissionRepository;

    public IntermissionController(IntermissionRepository intermissionRepository) {
        this.intermissionRepository = intermissionRepository;
    }


    @PostMapping
    public Intermission addIntermission(@RequestBody Intermission intermission) {
        intermissionRepository.save(intermission);
        return intermission;
    }

    @GetMapping("/all")
    public List<Intermission> getAllIntermission(){
        return intermissionRepository.findAll();
    }
}
