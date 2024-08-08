package com.example.autodealer.controller;


import com.example.autodealer.entity.Appointment;
import com.example.autodealer.entity.Make;
import com.example.autodealer.service.MakeService;
import com.example.autodealer.service.ModelService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/make")
public class MakeController {

    private MakeService makeService;


    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @PostMapping("/add")
    public String createModel(@RequestBody Make make) {
        return makeService.addMake(make);
    }

    @GetMapping("/get")
    public List<Make> getModels() {
        return makeService.getAllMakes();
    }

    @GetMapping("/getById/{makeId}")
    public Make getMakeById(@PathVariable (name = "makeId") Long id){
        return makeService.getMakeById(id);
    }


    @DeleteMapping("/delete/{makeId}")
    public boolean deleteMake(@PathVariable (name = "makeId") Long id) {
        return makeService.deleteMakeById(id);
    }

    @PutMapping("/update")
    public boolean updateMake(@RequestBody Make make) {
        return makeService.updateMake(make);
    }


}
