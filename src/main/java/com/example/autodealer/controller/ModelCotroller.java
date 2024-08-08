package com.example.autodealer.controller;


import com.example.autodealer.entity.Make;
import com.example.autodealer.entity.Model;
import com.example.autodealer.service.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelCotroller {


    private ModelService modelService;

    public ModelCotroller(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/add")
    public String addModel(@RequestBody Model model) {
       return modelService.addModel(model);
    }


    @GetMapping("/get")
    public List<Model> getModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/getById/{modelId}")
    public Model getModelById(@PathVariable (name = "modelId") Long id){
        return modelService.getModelById(id);
    }


    @DeleteMapping("/delete/{modelId}")
    public boolean deleteModel(@PathVariable (name = "modelId") Long id) {
        return modelService.deleteModelById(id);
    }

    @PutMapping("/update")
    public boolean updateModel(@RequestBody Model model) {
        return modelService.updateModel(model);
    }





}
