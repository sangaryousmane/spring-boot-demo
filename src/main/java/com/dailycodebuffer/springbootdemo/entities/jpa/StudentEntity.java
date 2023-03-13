package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "students",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_student_email",
                columnNames = "student_email_address"
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {

    @Id
    private String Id;
    private String name;

    @Column(name = "student_email_address")
    private String email;

    //    @JsonIgnore
    private String password;

    @OneToOne(optional = false,
            orphanRemoval = true,
            targetEntity = GuardianEntity.class)
    private GuardianEntity guardian;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "Id",
                    foreignKey = @ForeignKey(name = "student_FK")),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "course_id",
                    foreignKey = @ForeignKey(name = "course_FK")))
    private List<CourseEntity> courses;


    public void addCourse(CourseEntity course){
        this.courses.add(course);
    }
}
