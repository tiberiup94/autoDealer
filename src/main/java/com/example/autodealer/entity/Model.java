package com.example.autodealer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "models")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

}