package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "TeacherEntity")
@Getter @Setter @NoArgsConstructor
@Table(name = "teachers")
public class TeacherEntity {


    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "teacher_sequence")
    @Column(name="teacher_id", nullable = false, length = 80)
    private String id;

    @Column(name="first_name", length = 80, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 80, nullable = false)
    private String lastName;

    @OneToMany(
            mappedBy = "teacher",
            targetEntity = CourseEntity.class
    )
    private List<CourseEntity> courses;




}
