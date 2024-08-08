package com.example.autodealer.service;


import com.example.autodealer.entity.Make;
import com.example.autodealer.repository.MakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class MakeService {

    private MakeRepository makeRepository;

    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    public String addMake(Make make) {
        makeRepository.save(make);
        return "Make added";
    }

    public List<Make> getAllMakes() {
        return makeRepository.findAll();
    }


    public Make getMakeById(Long id) {

        return makeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public boolean deleteMakeById(Long id) {

        Make optional = makeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        makeRepository.delete(optional);
        return true;


    }

    public boolean updateMake(Make make) {

        Make optional = makeRepository.findById(make.getMakeId()).orElseThrow(NoSuchElementException::new);
        optional.setName(make.getName());
        makeRepository.save(optional);
        return true;


    }

}
