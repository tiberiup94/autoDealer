package com.example.autodealer.controller;


import com.example.autodealer.entity.Appointment;
import com.example.autodealer.entity.Make;
import com.example.autodealer.repository.AppointmentRepository;
import com.example.autodealer.service.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @PostMapping("/add")
    public String addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }

    @GetMapping("/get")

    public List<Appointment> getAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/delete/{authorId}")
    public String deleteAppointment(@PathVariable (name = "authorId") Long id) {
        return appointmentService.deleteAppointmentById(id);
    }

    @GetMapping("/getById/{makeId}")
    public Optional<Appointment> getMakeById(@PathVariable (name = "makeId") Long id){
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/update")
    public String updateAppointment(@RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment);
    }


}