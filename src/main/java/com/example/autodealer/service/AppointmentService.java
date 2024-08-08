package com.example.autodealer.service;

import com.example.autodealer.entity.Appointment;
import com.example.autodealer.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public String addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return "Appointment added successfully";
    }

    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {

        return appointmentRepository.findById(id);
    }

    public String deleteAppointmentById(Long id) {

        Optional<Appointment> optional = appointmentRepository.findById(id);
        if (optional.isPresent()) {
            appointmentRepository.delete(optional.get());
            return "Appointment deleted successfully";
        }
        return "Appointment not found";
    }

    public String updateAppointment(Appointment appointment) {

        Optional<Appointment> optional = appointmentRepository.findById(appointment.getAppointmentId());
        if (optional.isPresent()) {
            appointmentRepository.save(optional.get());
            return "Appointment updated successfully";
        }
        return "Appointment not found";
    }

}