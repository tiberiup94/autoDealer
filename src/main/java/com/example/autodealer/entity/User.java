package com.example.autodealer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long userId;

    private String fullName;
    private String email;
    private String phoneNumber;

    @OneToMany (mappedBy = "user")
    private List<Appointment> appointments = new ArrayList<>();


}
