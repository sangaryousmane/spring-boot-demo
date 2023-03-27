package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "TeacherEntity")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teachers")
@Builder
@AllArgsConstructor
public class TeacherEntity {


    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence")
    @Column(name = "teacher_id", nullable = false, length = 80)
    private Integer Id;

    @Column(name = "first_name", length = 80, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 80, nullable = false)
    private String lastName;

    public TeacherEntity(Integer id) {
        Id = id;
    }
}
