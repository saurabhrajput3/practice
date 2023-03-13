package com.chatapplication.chat.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_status")
public class Status {

    @Id
    @Column(name="status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    @Column(name="status_name")
    private String statusName;
    @Column(name="status_description")
    private String statusDescription;

}
