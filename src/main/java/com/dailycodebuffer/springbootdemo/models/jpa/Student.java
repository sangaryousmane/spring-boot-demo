package com.dailycodebuffer.springbootdemo.models.jpa;


import com.dailycodebuffer.springbootdemo.entities.jpa.Guardian;
import lombok.*;

@Data
@Builder @NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String Id;
    private String name;
    private String email;
    private String password;
    private Guardian guardian;
}
