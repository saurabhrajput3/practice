package com.portal.studentinfo.studentinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Course {

    @Id

    private String ID;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> studentList = new ArrayList<>();
}
