package com.dailycodebuffer.springbootdemo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.context.annotation.Primary;


@Entity(name = "CustomerEntity")
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustomerEntity {


    @Id
    @Column(name = "customer_id")
    private String Id;
    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
    private String address;
}
