package com.dailycodebuffer.springbootdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "EmployeeEntity")
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter @Table(name = "employees")
public class EmployeeEntity {


    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;

    //    @JsonIgnore
    private String department;


    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
