package com.dailycodebuffer.springbootdemo.models.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Course {

    private Integer courseId;
    private String title;
    private Integer credit;
    private Teacher teacher;
    private CourseMaterial courseMaterial;


}
