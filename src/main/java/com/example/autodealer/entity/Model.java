package com.example.autodealer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "models")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue
    private long modelId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "makeId")
    private Make make;

    @OneToMany(mappedBy = "model")
    private List<Vehicle> vehicle = new ArrayList<>();
}