package com.example.autodealer.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {


    @Id
    @GeneratedValue
    private long appointmentId;

    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


}
