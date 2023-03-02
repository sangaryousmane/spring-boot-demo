package com.dailycodebuffer.springbootdemo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"department", "emailId", "lastName"})
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;

//    @JsonIgnore
    private String department;


}
