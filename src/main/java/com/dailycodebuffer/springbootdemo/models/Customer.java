package com.dailycodebuffer.springbootdemo.models;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Customer {

    private String Id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

}
