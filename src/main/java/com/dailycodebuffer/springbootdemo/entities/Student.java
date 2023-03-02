package com.dailycodebuffer.springbootdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "students")
public class Student {

    @Id
    private String Id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
}
