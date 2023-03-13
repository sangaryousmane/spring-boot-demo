package com.dailycodebuffer.springbootdemo.entities.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "CourseEntity")
@Getter @Setter @NoArgsConstructor
@Table(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    private String title;
    private Long credit;

    @ManyToMany(mappedBy = "courses",
            targetEntity = StudentEntity.class)
    private List<StudentEntity> students=new ArrayList<>();


    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY,
            targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id",
            referencedColumnName ="teacher_id",
            foreignKey = @ForeignKey(name = "teacher_FK")
    )
    private TeacherEntity teacher;


    @OneToOne(mappedBy = "course", orphanRemoval = true)
    private CourseMaterialEntity courseMaterial;

    public void addStudent(StudentEntity student){
        this.students.add(student);
    }
}
