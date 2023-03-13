package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "GuardianEntity")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "guardians",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_email_id",
                columnNames = "email_address"))
public class GuardianEntity {

    @Id
    private String name;

    @Column(name = "email_address")
    private String email;
    private String mobile;

    @OneToOne(mappedBy = "guardian")
    private StudentEntity student;
}
