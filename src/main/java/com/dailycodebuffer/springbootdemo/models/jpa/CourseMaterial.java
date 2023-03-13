package com.dailycodebuffer.springbootdemo.models.jpa;


import lombok.Data;

@Data
public class CourseMaterial {

    private Long courseMaterialId;
    private String url;
    private Course course;
}
