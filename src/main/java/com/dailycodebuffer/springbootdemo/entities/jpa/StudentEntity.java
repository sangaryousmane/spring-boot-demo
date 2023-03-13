package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long Id;
    private String name;

    @Column(name = "student_email_address")
    private String email;

    //    @JsonIgnore
    private String password;



    @Embedded
    private Guardian guardian;

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
    private List<CourseEntity> courses=new ArrayList<>();

    public StudentEntity(Long id) {
        Id = id;
    }

    public void addCourse(CourseEntity course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", guardian=" + guardian +
                '}';
    }
}
