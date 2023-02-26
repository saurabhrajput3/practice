package com.portal.studentinfo.studentinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id

    private String ID;

    private String title;
    private String author;
    private String description;
    private String price;


    @ManyToOne
    private Student student;

}
