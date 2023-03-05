package com.dailycodebuffer.springbootdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "students")
@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    private String Id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
}
