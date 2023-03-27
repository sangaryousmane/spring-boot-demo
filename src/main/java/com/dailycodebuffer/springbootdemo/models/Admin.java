package com.dailycodebuffer.springbootdemo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;
}
