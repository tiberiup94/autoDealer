package com.example.autodealer.entity;


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
    @Column(name = "make_id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "make")
    private List<Model> models = new ArrayList<>();


}
