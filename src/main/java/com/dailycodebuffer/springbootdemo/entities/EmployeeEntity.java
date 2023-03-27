package com.dailycodebuffer.springbootdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "EmployeeEntity")
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter @Table(name = "employees") @Builder
public class EmployeeEntity {


    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;

    //    @JsonIgnore
    private String department;


    public EmployeeEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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
