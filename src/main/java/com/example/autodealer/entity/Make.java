package com.example.autodealer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "makes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Make {

    @Id
    @GeneratedValue
    private long makeId;

    private String name;

    @OneToMany(mappedBy = "make")
    @JsonIgnore
    private List<Model> models = new ArrayList<>();




}
