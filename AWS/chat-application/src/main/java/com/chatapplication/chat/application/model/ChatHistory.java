package com.chatapplication.chat.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_chat_history")
public class ChatHistory {
    @Id
    @Column(name="chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;
    @JoinColumn(name="receiver_id")
    @ManyToOne
    private Users receiver;
    @JoinColumn(name="sender_id")
    @ManyToOne
    private Users sender;
    @Column(name="message")
    private String message;
    @Column(name="created_date")
    private Timestamp createdDate;
    @Column(name="updated_date")
    private Timestamp updatedDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;


}
