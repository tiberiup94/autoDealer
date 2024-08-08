package com.example.autodealer.service;


import com.example.autodealer.entity.Make;
import com.example.autodealer.entity.Model;
import com.example.autodealer.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;




    public String addModel(Model model) {
        modelRepository.save(model);
        return "Model added";
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(Long id) {

        return modelRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public boolean deleteModelById(Long id) {

        Model optional = modelRepository.findById(id).orElseThrow(NoSuchElementException::new);
        modelRepository.delete(optional);
        return true;


    }

    public boolean updateModel(Model model) {

        Model optional = modelRepository.findById(model.getModelId()).orElseThrow(NoSuchElementException::new);
        modelRepository.save(optional);
        return true;


    }


}
