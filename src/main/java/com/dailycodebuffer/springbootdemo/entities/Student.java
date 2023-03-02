package com.dailycodebuffer.springbootdemo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Student {

    private String Id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
}
