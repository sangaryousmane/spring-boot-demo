package com.dailycodebuffer.springbootdemo.entities.jpa;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "CourseEntity")
@Getter @Setter @NoArgsConstructor
@Table(name = "courses")
@Builder @ToString
@AllArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    private String title;
    private Long credit;

    @ManyToMany(mappedBy = "courses",
            targetEntity = StudentEntity.class)
    @ToString.Exclude
    private List<StudentEntity> students=new ArrayList<>();


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id",
            referencedColumnName ="teacher_id",
            foreignKey = @ForeignKey(name = "teacher_FK")
    )
    @ToString.Exclude
    private TeacherEntity teacher;


    public CourseEntity(Long courseId) {
        this.courseId = courseId;
    }

    @OneToOne(mappedBy = "course", orphanRemoval = true)
    private CourseMaterialEntity courseMaterial;

    public void addStudent(StudentEntity student){
        this.students.add(student);
    }
}
