package com.example.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "dead_line")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadLine;
    @Column(name = "color")
    private String color;
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @ManyToOne
    private StudentModel studentModel;
}
