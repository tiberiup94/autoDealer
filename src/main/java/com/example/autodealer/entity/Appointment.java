package com.example.autodealer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table(name = "appointments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {


    @Id
    @GeneratedValue
    private long appointmentId;

    @Column
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


}
