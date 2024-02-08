package com.example.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "git_hub")
    private String gitHub;
    @Size(min = 3)
    @Column(name = "start")
    private String start;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentModel")
    private Set<TaskModel> tasks = new HashSet<>();
}
