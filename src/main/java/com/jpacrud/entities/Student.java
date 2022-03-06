package com.jpacrud.entities;

import lombok.Data;

import javax.persistence.*;

@Data   //lombok
@Entity
@Table(name = "student_table") //if omitted it assumes that the table name is "Student", same as class name
public class Student {
    //camelCase table field names are converted into snake_case automatically in db
    //however while saving/calling api you must use filed names exactly as written in the model/entity class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String firstName;
    private String lastName;
    private int rollNumber;
    private String section;
}
