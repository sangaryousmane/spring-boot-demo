package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "CourseMaterialEntity")
@Getter @Setter @NoArgsConstructor
@Table(name = "course_materials")
@Builder @AllArgsConstructor
public class CourseMaterialEntity {

    @Id
    @Column(name = "course_material_id")
    @SequenceGenerator(
            name = "material_sequence_generator",
            sequenceName = "material_sequence_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long courseMaterialId;

    @Column(nullable = false)
    private String url;

    @OneToOne(orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "course_id")
    private CourseEntity course;

    @Override
    public String toString() {
        return "CourseMaterialEntity{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
                '}';
    }
}
