package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CourseMaterialEntity")
@Getter @Setter @NoArgsConstructor
@Table(name = "course_materials")
public class CourseMaterialEntity {

    @Id
    @Column(name = "course_material_id")
    private Long courseMaterialId;

    @Column(nullable = false)
    private String url;

    @OneToOne(optional = false, orphanRemoval = true)
    private CourseEntity course;
}
